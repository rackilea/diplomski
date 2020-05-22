import java.io.IOException;

import java.io.InputStream;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;

/**
 * http://zerocredibility.wordpress.com/2011/01/27/android-bitmap-scaling/
 * 
 */
public final class 

BitmapScaler {

    /**
     * 
     * @param uri
     * @param context
     * @param newWidth
     *            Image will not exceed this width
     * @param newHeight
     *            Image will not exceed this height
     * @return
     * @throws IOException
     */
    public static Bitmap ScaleBitmap(Uri uri, Context context,
            int newWidth, int newHeight, int targetWidth, int targetHeight)
            throws IOException {
        final ContentResolver contentResolver = context.getContentResolver();
        int sample = 1;
        {
            InputStream is = contentResolver.openInputStream(uri);
            try {
                sample = getRoughSize(is, newWidth, newHeight);
            } finally {
                is.close();
            }
        }
        {
            InputStream is = contentResolver.openInputStream(uri);
            try {
                Bitmap temp = roughScaleImage(is, sample);
                try {
                    return scaleImage(temp, newWidth, newHeight, targetWidth,
                            targetHeight);
                } finally {
                    temp.recycle();
                }
            } finally {
                is.close();
            }
        }
    }

    private static Bitmap scaleImage(final Bitmap source, final int maxWidth,
            final int maxHeight, final int targetWidth, final int targetHeight) {

        int newWidth = maxWidth;
        int newHeight = maxHeight;

        final int sourceHeight = source.getHeight();
        final int sourceWidth = source.getWidth();
        final int angle = sourceHeight > sourceWidth ? -90 : 0;
        final boolean rotate = angle != 0;
        final boolean nintey = (angle == 90) || (angle == -90);
        final int width = nintey ? sourceHeight : sourceWidth;
        final int height = nintey ? sourceWidth : sourceHeight;

        final float scaleByWidth = ((float) newWidth / width);
        int testNewHeight = (int) (height * scaleByWidth);

        float scale;

        if (testNewHeight > newHeight) { // then we must scale to match
                                            // newHeight instead of new width
            final float scaleByHeight = ((float) newHeight / height);
            newWidth = (int) (width * scaleByHeight);
            scale = scaleByHeight;
        } else {
            // accept the scale
            newHeight = testNewHeight;
            scale = scaleByWidth;
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        if (rotate) {
            matrix.postRotate(angle);
            matrix.postTranslate(0, newHeight);
        }
        matrix.postTranslate((maxWidth - newWidth) / 2,
                (maxHeight - newHeight) / 2);

        Bitmap b = Bitmap.createBitmap(targetWidth, targetHeight,
                Bitmap.Config.ARGB_8888);
        Paint p = new Paint(Paint.FILTER_BITMAP_FLAG);
        Canvas c = new Canvas(b);
        c.drawBitmap(source, matrix, p);
        return b;
    }

    private static Bitmap roughScaleImage(InputStream is, int sample) {
        BitmapFactory.Options scaledOpts = new BitmapFactory.Options();
        scaledOpts.inSampleSize = sample;
        return BitmapFactory.decodeStream(is, null, scaledOpts);
    }

    private static int getRoughSize(InputStream is, int newWidth, int newHeight) {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, o);

        return getRoughSize(o.outWidth, o.outHeight, newWidth, newHeight);
    }

    private static int getRoughSize(int width, int height, int newWidth,
            int newHeight) {
        int sample = 1;

        while (true) {
            if (width / 2 < newWidth || height / 2 < newHeight) {
                break;
            }
            width /= 2;
            height /= 2;
            sample *= 2;
        }
        return sample;
    }
}