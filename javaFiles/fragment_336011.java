public static void main(String[] args) throws Exception {
    final BufferedImage image = ...

    Graphics g = image.getGraphics();
    g.setFont(g.getFont().deriveFont(20f)); // select compatible font
    g.drawString("numbers", 100, 100); // center on your image using image size
    g.dispose();

    ImageIO.write(image, "png", new File("barcode.png"));
}