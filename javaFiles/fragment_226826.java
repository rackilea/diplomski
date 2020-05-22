import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Convolution {
    public static void main( String[] args ) throws Exception {
        File inputFile = new File("apple.jpg");
        BufferedImage bufferedImage = ImageIO.read(inputFile);
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();

        System.out.println("w=" + w + ", h=" + h);

        // Get Pixels
        int[] image = new int[w * h];
        bufferedImage.getRGB(0, 0, w, h, image, 0, w);

        // Convert to simple grayscale
        for ( int y = 0; y < h; y++ ) {
            for ( int x = 0; x < w; x++ ) {
                int idx = ( y * w ) + x;
                int p = image[idx];
                int r = p & 0x00FF0000 >> 16;
                int g = p & 0x0000FF >> 8;
                int b = p & 0x000000FF;
                image[idx] = (int) ( ( r + g + b ) / 3.0 );
            }
        }

        int convolutionSize = 3;
        int[][] convolution = { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } };

        int[] newImage = new int[w * h];
        // Apply the convolution to the whole image, note that we start at
        // 1 instead 0 zero to avoid out-of-bounds access
        for ( int y = 1; y + 1 < h; y++ ) {
            for ( int x = 1; x + 1 < w; x++ ) {
                int idx = ( y * w ) + x;

                // Apply the convolution
                for ( int cy = 0; cy < convolutionSize; cy++ ) {
                    for ( int cx = 0; cx < convolutionSize; cx++ ) {
                        int cIdx = ( ( ( y - 1 ) + cy ) * w )
                                + ( ( x - 1 ) + cx );
                        newImage[idx] += convolution[cy][cx] * image[cIdx];
                    }
                }

                // pixel value rounding
                if ( newImage[idx] < 0 ) {
                    newImage[idx] = -newImage[idx];
                } else {
                    newImage[idx] = 0;
                }
                if ( newImage[idx] > 0 ) {
                    newImage[idx] = 120 - newImage[idx];
                } else {
                    newImage[idx] = 255;
                }

            }
        }

        // Convert to "proper" grayscale
        for ( int y = 0; y < h; y++ ) {
            for ( int x = 0; x < w; x++ ) {
                int idx = ( y * w ) + x;
                int p = newImage[idx];
                newImage[idx] = 0xFF000000 | ( p << 16 ) | ( p << 8 ) | p;
            }
        }

        // Set the image to have the new values;
        bufferedImage.setRGB(0, 0, w, h, newImage, 0, w);

        // Write the new image as a PNG to avoid lossey compression,
        // and its eaiser than trying to display an image in Java.
        ImageIO.write(bufferedImage, "png", new File("new_apple.png"));
    }
}