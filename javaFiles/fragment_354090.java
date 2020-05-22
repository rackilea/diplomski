import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import static android.graphics.Matrix.ScaleToFit.FILL;
import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static android.graphics.Path.Direction.CW;
import static android.graphics.PixelFormat.TRANSPARENT;
import static android.graphics.Shader.TileMode.CLAMP;
import static test.com.testrotationanimation.BubbleDrawable.Corner.TOP_LEFT;

public final class BubbleDrawable extends Drawable {
    private final Matrix mMatrix = new Matrix();
    private final Paint mPaint = new Paint(ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();
    private final RectF mSrcRect = new RectF();
    private final RectF mDstRect = new RectF();
    private final Shader mShader;

    private Corner mArrowCorner = TOP_LEFT;

    public BubbleDrawable(Bitmap bitmap, Corner arrowCorner) {
        // Initialize a BitmapShader with the image you wish to draw
        // (you can use other TileModes like REPEAT or MIRROR if you prefer)
        mShader = new BitmapShader(bitmap, CLAMP, CLAMP);
        mPaint.setShader(mShader);

        // Save the bounds of the bitmap as the src rectangle -- will
        // be used later to update the matrix when the bounds change
        // so that the image fits within the bounds of this drawable
        mSrcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());

        // Set the corner in which the arrow will be drawn
        mArrowCorner = arrowCorner;
    }

    public BubbleDrawable(Context ctx, int drawableResource, Corner arrowCorner) {
        this(BitmapFactory.decodeResource(ctx.getResources(), drawableResource), arrowCorner);
    }

    public Corner getArrowCorner() {
        return mArrowCorner;
    }

    public void setArrowCorner(Corner corner) {
        mArrowCorner = corner;
        updatePath();
        invalidateSelf();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        updateMatrix(bounds);
        updatePath();
    }

    private void updateMatrix(Rect bounds) {
        // Set the destination rectangle for the bitmap to be the
        // new drawable bounds
        mDstRect.set(bounds);

        // Scale the bitmap's rectangle to the bounds of this drawable
        mMatrix.setRectToRect(mSrcRect, mDstRect, FILL);

        // Update the shader's matrix (to draw the bitmap at the right size)
        mShader.setLocalMatrix(mMatrix);
    }

    private void updatePath() {
        final Rect bounds = getBounds();
        final float x = bounds.exactCenterX();
        final float y = bounds.exactCenterY();

        // Draw the initial circle (same for all corners)
        mPath.reset();
        mPath.addCircle(x, y, Math.min(x, y), CW);

        // Add the rectangle which intersects with the center,
        // based on the corner in which the arrow should draw
        switch (mArrowCorner) {
            case TOP_LEFT:
                mPath.addRect(bounds.left, bounds.top, x, y, CW);
                break;
            case TOP_RIGHT:
                mPath.addRect(x, bounds.top, bounds.right, y, CW);
                break;
            case BOTTOM_LEFT:
                mPath.addRect(bounds.left, y, x, bounds.bottom, CW);
                break;
            case BOTTOM_RIGHT:
                mPath.addRect(x, y, bounds.right, bounds.bottom, CW);
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        // Easy enough, just draw the path using the paint.
        // It already has the BitmapShader applied which
        // will do the work for you.
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public int getOpacity() {
        // Indicate that this Drawable has fully-transparent pixel values
        return TRANSPARENT;
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        // Yay, you can even support color filters for your drawable
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public void setAlpha(int i) {
        // You could do this by doing some canvas magic but I'm 
        // lazy and don't feel like it. Exercise for the reader. :)
        throw new UnsupportedOperationException("Not implemented.");
    }

    public enum Corner {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }
}