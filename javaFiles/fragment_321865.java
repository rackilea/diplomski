public class GetImageColorComponents {
  public static void main(String... args) throws Exception {
    BufferedImage img = ImageIO.read(GetImageColorComponents.class
                                     .getResourceAsStream("/image.png"));
    int[] colors = new int[img.getWidth() * img.getHeight()];
    img.getRGB(0, 0, img.getWidth(), img.getHeight(), colors, 0, img.getWidth());

    int[] red = new int[colors.length];
    int[] green = new int[colors.length];
    int[] blue = new int[colors.length];

    for (int i = 0; i < colors.length; i++) {
      Color color = new Color(colors[i]);
      red[i] = color.getRed();
      green[i] = color.getGreen();
      blue[i] = color.getBlue();
    }
  }
}