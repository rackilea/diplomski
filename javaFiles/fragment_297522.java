setSize(getPreferredSize());
BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g = image.createGraphics();
printAll(g);
g.dispose();
try { 
    ImageIO.write(image, "png", new File([location goes here]); 
} catch (IOException e) {
    e.printStackTrace();
}