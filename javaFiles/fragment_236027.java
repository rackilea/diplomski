public static void main(String[] args) throws IOException {
    URL imageUrl = new URL("http://www.google.com/intl/en_ALL/images/logo.gif");
    BufferedImage image = ImageIO.read(imageUrl);
    System.out.println("Width="+image.getWidth());
    System.out.println("Height="+image.getHeight());
}