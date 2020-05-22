GraphicsConfiguration config = new JFrame().getGraphicsConfiguration();
// Or better, use your main GUI component instead of new JFrame()
BufferedImage fixedImg = config.createCompatibleImage(img.getWidth(), img.getHeight(), Transparency.TRANSLUCENT);
Graphics2D fig = fixedImg.createGraphics();
fig.drawImage(img, 0, 0, null);
fig.dispose();
fixedImg.flush();