@Override
protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  if (displayImage != null) {
     int width = getWidth();
     int height = getHeight();
     g.drawImage(displayImage, 0, 0, width, height, null);
  }
}

// ....

  @Override
  protected void process(List<BufferedImage> chunks) {
     for (BufferedImage image : chunks) {
        displayImage = image;
        repaint();
     }
  }