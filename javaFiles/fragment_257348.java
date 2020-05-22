public void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D g2 = (Graphics2D) g;

    BufferedImage imageBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics imageG2 = imageBuffer.createGraphics();

    // do custom painting onto imageG2...

    // save imageBuffer

    g2.drawImage(imageBuffer, 0, 0, this);  // draw onto component
}