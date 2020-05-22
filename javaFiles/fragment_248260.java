package com.example.binarizeimage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.example.binarizeimage.R.drawable;

/**
 * @author Sherif elKhatib - shush
 *
 */
public class MainActivity extends Activity {
    /**
     * Boolean that tells me how to treat a transparent pixel (Should it be black?)
     */
    private static final boolean TRASNPARENT_IS_BLACK = false;
    /**
     * This is a point that will break the space into Black or white
     * In real words, if the distance between WHITE and BLACK is D;
     * then we should be this percent far from WHITE to be in the black region.
     * Example: If this value is 0.5, the space is equally split.  
     */
    private static final double SPACE_BREAKING_POINT = 13.0/30.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this is the original image
        Bitmap theOriginalImage = BitmapFactory.decodeResource(this.getResources(), drawable.ic_launcher);
        //this is the image that is binarized
        Bitmap binarizedImage = convertToMutable(theOriginalImage);
        // I will look at each pixel and use the function shouldBeBlack to decide 
        // whether to make it black or otherwise white
        for(int i=0;i<binarizedImage.getWidth();i++) {
            for(int c=0;c<binarizedImage.getHeight();c++) {
                int pixel = binarizedImage.getPixel(i, c);
                if(shouldBeBlack(pixel))
                    binarizedImage.setPixel(i, c, Color.BLACK);
                else
                    binarizedImage.setPixel(i, c, Color.WHITE);
            }
        }


        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        ImageView ivb = (ImageView) findViewById(R.id.ImageView01);
        //show the original image
        iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), drawable.ic_launcher));
        //show the binarized image
        ivb.setImageBitmap(binarizedImage);
    }
    /**
     * @param pixel the pixel that we need to decide on
     * @return boolean indicating whether this pixel should be black
     */
    private static boolean shouldBeBlack(int pixel) {
        int alpha = Color.alpha(pixel);
        int redValue = Color.red(pixel);
        int blueValue = Color.blue(pixel);
        int greenValue = Color.green(pixel);
        if(alpha == 0x00) //if this pixel is transparent let me use TRASNPARENT_IS_BLACK
            return TRASNPARENT_IS_BLACK;
        // distance from the white extreme
        double distanceFromWhite = Math.sqrt(Math.pow(0xff - redValue, 2) + Math.pow(0xff - blueValue, 2) + Math.pow(0xff - greenValue, 2));
        // distance from the black extreme //this should not be computed and might be as well a function of distanceFromWhite and the whole distance
        double distanceFromBlack = Math.sqrt(Math.pow(0x00 - redValue, 2) + Math.pow(0x00 - blueValue, 2) + Math.pow(0x00 - greenValue, 2));
        // distance between the extremes //this is a constant that should not be computed :p
        double distance = distanceFromBlack + distanceFromWhite;
        // distance between the extremes
        return ((distanceFromWhite/distance)>SPACE_BREAKING_POINT);
    }
    /**
     * @author Derzu
     * 
     * @see http://stackoverflow.com/a/9194259/833622
     * 
     * Converts a immutable bitmap to a mutable bitmap. This operation doesn't allocates
     * more memory that there is already allocated.
     * 
     * @param imgIn - Source image. It will be released, and should not be used more
     * @return a copy of imgIn, but muttable.
     */
    public static Bitmap convertToMutable(Bitmap imgIn) {
        try {
            //this is the file going to use temporally to save the bytes. 
            // This file will not be a image, it will store the raw image data.
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");

            //Open an RandomAccessFile
            //Make sure you have added uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
            //into AndroidManifest.xml file
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            // get the width and height of the source bitmap.
            int width = imgIn.getWidth();
            int height = imgIn.getHeight();
            Config type = imgIn.getConfig();

            //Copy the byte to the file
            //Assume source bitmap loaded using options.inPreferredConfig = Config.ARGB_8888;
            FileChannel channel = randomAccessFile.getChannel();
            MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, imgIn.getRowBytes()*height);
            imgIn.copyPixelsToBuffer(map);
            //recycle the source bitmap, this will be no longer used.
            imgIn.recycle();
            System.gc();// try to force the bytes from the imgIn to be released

            //Create a new bitmap to load the bitmap again. Probably the memory will be available. 
            imgIn = Bitmap.createBitmap(width, height, type);
            map.position(0);
            //load it back from temporary 
            imgIn.copyPixelsFromBuffer(map);
            //close the temporary file and channel , then delete that also
            channel.close();
            randomAccessFile.close();

            // delete the temp file
            file.delete();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return imgIn;
    }
}