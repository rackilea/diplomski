static private Image createTestImage(final int resolution) {
    final Image image = new BufferedImage(resolution, resolution, BufferedImage.TYPE_INT_ARGB);
    final Graphics g = image.getGraphics();
    final int points = (resolution * 72) / 96;
    g.setColor(new Color(.42f, .42f, 1.0f, .5242f));
    g.setFont(new Font("Dialog", Font.BOLD, points));
    g.drawString("!X!", 2, points);
    g.setColor(Color.BLACK);
    g.drawOval(0, 0, image.getWidth(null) - 1, image.getHeight(null) - 1);
    g.drawOval(11, 11, image.getWidth(null) - 23, image.getHeight(null) - 23);
    g.drawOval(22, 22, image.getWidth(null) - 45, image.getHeight(null) - 45);
    return image;
}