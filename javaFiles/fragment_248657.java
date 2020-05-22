public class BufferedImageUtil{

  public static int getRed(BufferedImage image, int x, int y) {
    return (image.getRGB(x, y) >> 16) & 0xFF;
  }

  //add your other methods
}