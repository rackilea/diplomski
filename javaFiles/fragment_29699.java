import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

public class ReplacePattern {

    public static void main(String[] args) throws Exception {
        BufferedImage containingImage = ImageIO.read(new File("fourWhites.png"));
        BufferedImage toBeReplaced = ImageIO.read(new File("oneWhite.png"));
        BufferedImage replaceWithThis = ImageIO.read(new File("oneRed.png"));
        BufferedImage replaced = replaceInsideBufferedImage(containingImage, toBeReplaced, replaceWithThis);
        ImageIO.write(replaced, "png", new File("fourReds.png"));
    }

    public static BufferedImage replaceInsideBufferedImage(BufferedImage containingImage, BufferedImage toBeReplaced, BufferedImage replaceWithThis) {
        BufferedImage returnImage = deepCopyImage(containingImage);
        for (int x = 0; x+toBeReplaced.getWidth() < containingImage.getWidth(); x++) {
            for (int y = 0; y+toBeReplaced.getHeight() < containingImage.getHeight(); y++) {
                BufferedImage subImg = containingImage.getSubimage(x, y, toBeReplaced.getWidth(), toBeReplaced.getHeight());
                if (imageEquals(subImg,toBeReplaced)) {
                    for (int sx = 0; sx < replaceWithThis.getWidth(); sx++) {
                        for (int sy = 0; sy < replaceWithThis.getHeight(); sy++) {
                            returnImage.setRGB(x+sx, y+sy, replaceWithThis.getRGB(sx, sy));
                        }
                    }
                }
            }
        }
        return returnImage;
    }

    // http://stackoverflow.com/a/3514297/1850609
    public static BufferedImage deepCopyImage(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    // http://stackoverflow.com/a/11006474/1850609
    private static boolean imageEquals(BufferedImage image1, BufferedImage image2) {
        int width;
        int height;
        boolean imagesEqual = true;
        if( image1.getWidth()  == ( width  = image2.getWidth() ) && 
            image1.getHeight() == ( height = image2.getHeight() ) ){
            for(int x = 0;imagesEqual == true && x < width; x++){
                for(int y = 0;imagesEqual == true && y < height; y++){
                    if( image1.getRGB(x, y) != image2.getRGB(x, y) ){
                        imagesEqual = false;
                    }
                }
            }
        }else{
            imagesEqual = false;
        }
        return imagesEqual;
    }
}