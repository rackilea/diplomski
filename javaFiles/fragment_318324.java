public static BufferedImage toBufferedImage(Component component) {
    BufferedImage image = new BufferedImage(component.getWidth(), 
        component.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    component.paint(g);
    return image;
}