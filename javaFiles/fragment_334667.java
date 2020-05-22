BufferedImage cropped = new BufferedImage(
    (int) imgWidth - 100,
    (int) imgHeight - 100,
    bImg.getType());

Graphics g = cropped.getGraphics();
g.drawImage(bImg, -100, -100, null);
g.dispose();

gc.drawImage(SwingFXUtils.toFXImage(cropped, null), 100, 100);