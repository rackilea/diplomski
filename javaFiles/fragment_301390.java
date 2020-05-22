BufferedImage display = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g = display.createGraphics();
try {
    g.drawImage(original, 0, 0, null);
}
finally {
    g.dispose();
}