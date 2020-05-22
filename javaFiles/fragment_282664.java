public static void main(String[] args) throws IOException {
    BufferedImage image = new BufferedImage(512, 256,
            BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.BLACK);
    for (int i = 0; i < 10; ++i)
        drawString(g, "i am drawn with seperation " + i, 24, 24 + 16 * i, i);
    ImageIO.write(image, "png", new File("output.png"));
}