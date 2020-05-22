List<DrawableAnnotation> annotations = new ArrayList<>(25);
RectangleAnnotation ca = new RectangleAnnotation(20, 100, 60, 110);
ca.setColor(Color.BLUE);
ca.setStroke(dashed);
// Any other annotations...

File f = new File("profile.jpeg");
BufferedImage image2 = ImageIO.read(f);
Graphics2D g2d = image2.createGraphics();
g2d.drawImage(image2, x, y, null);
for (DrawableAnnotation d : annotations) {
    d.paint(g2d);
}
g2d.dispose();