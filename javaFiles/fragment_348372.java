public void saveImage() throws IOException {
   BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
   Graphics2D graphics = image.createGraphics();
   graphics.setColor(Color.black);
   for (Line line : shapes) {
            graphics.drawLine(line.getFirst().x, line.getFirst().y, line.getLast().x, line.getLast().y);
   }
   graphics.dispose();
        ImageIO.write(image, "png", new File("Beniton drawing.png"));