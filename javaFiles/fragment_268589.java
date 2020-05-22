import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class getPixelRGB1 {

    private static String[][] img_hex2;
    private static String[][] img_hex4;
    private static String[][] img2_hex2;
    private static String[][] img2_hex4;

    public static void main(String[] args) throws IOException {
        FileInputStream image = null;
        FileInputStream image2 = null;

        getPixelData1 newPD = new getPixelData1();
        compareHexaRGB hexRGB = new compareHexaRGB();

        try {
            BufferedImage img, img2;

            File file = new File("eye1.jpg");
            File file2 = new File("eye2.jpg");
            image = new FileInputStream(file);
            image2 = new FileInputStream(file2);
            img = ImageIO.read(image);
            img2 = ImageIO.read(image2);

            int rowcol;
            int width = img.getWidth();
            int height = img.getHeight();
            hexRGB.compareHexaRGB(width, height);
            System.out.println("Image's Width: " + width);
            System.out.println("Image's Height: " + height);
            // hexRGB.check();
            int[][] pixelData = new int[width * height][3];

            System.out.println("Pixel Data: " + pixelData);

            int[] rgb;
            int count = 0;

            img_hex2 = new String[width][height];
            img_hex4 = new String[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    rgb = newPD.getPixelData(img, i, j);

                    for (int k = 0; k < rgb.length; k++) {
                        pixelData[count][k] = rgb[k];
                        // img_hex2[i][j] = newPD.getHexa2();
                        // img_hex4[i][j] = newPD.getHexa4();
                    }

                    img_hex2[i][j] = newPD.getHexa2(); // the code runs and
                                                        // stops here
                    img_hex4[i][j] = newPD.getHexa4();
                    System.out.println("Output: " + img_hex2[i][j]);
                    System.out.println("Output: " + img_hex4[i][j]);
                    count++;
                    System.out.println("\nRGB Counts: " + count);
                }
            }

            int width2 = img2.getWidth();
            int height2 = img2.getHeight();
            System.out.println("Image's Width: " + width2);
            System.out.println("Image's Height: " + height2);

            int[][] pixelData2 = new int[width2 * height2][3];

            System.out.println("Pixel Data: " + pixelData2);

            int[] rgb2;
            int counter = 0;

            img2_hex2 = new String[width2][height2];
            img2_hex4 = new String[width2][height2];

            for (int i = 0; i < width2; i++) {
                for (int j = 0; j < height2; j++) {
                    rgb2 = newPD.getPixelData(img2, i, j);

                    for (int k = 0; k < rgb2.length; k++) {
                        pixelData2[counter][k] = rgb2[k];

                    }
                    img2_hex2[i][j] = newPD.getHexa2();
                    img2_hex4[i][j] = newPD.getHexa4();
                    counter++;
                    System.out.println("\nRGB2 Counts: " + counter);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(getPixelRGB1.class.getName()).log(Level.SEVERE,
                    null, ex);
        } finally {
            try {
                image.close();
            } catch (IOException ex) {
                Logger.getLogger(getPixelRGB1.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        hexRGB.check();
    }

    public String[][] display_imgHex2() {
        return img_hex2;
    }

    public String[][] display_imgHex4() {
        return img_hex4;
    }

    public String[][] display_img2Hex2() {
        return img2_hex2;
    }

    public String[][] display_img2Hex4() {
        return img2_hex4;
    }
}