public static void main(String... args) throws Exception {

    BufferedImage image = ImageIO.read(
         new URL("http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));

    int w = image.getWidth();
    int h = image.getHeight();

    int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w); 

    Color c = new Color(dataBuffInt[100]);

    System.out.println(c.getRed());   // = (dataBuffInt[100] >> 16) & 0xFF
    System.out.println(c.getGreen()); // = (dataBuffInt[100] >> 8)  & 0xFF
    System.out.println(c.getBlue());  // = (dataBuffInt[100] >> 0)  & 0xFF
    System.out.println(c.getAlpha()); // = (dataBuffInt[100] >> 24) & 0xFF
}