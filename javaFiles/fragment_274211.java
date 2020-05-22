BufferedImage source = ImageIO.read(new File("Example.jpg"));
GeneralPath clip = new GeneralPath();
clip.moveTo(65, 123);
clip.lineTo(241, 178);
clip.lineTo(268, 405);
clip.lineTo(145, 512);
clip.closePath();

Rectangle bounds = clip.getBounds();
BufferedImage img = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = img.createGraphics();
clip.transform(AffineTransform.getTranslateInstance(-65, -123));
g2d.setClip(clip);
g2d.translate(-65, -123);
g2d.drawImage(source, 0, 0, null);
g2d.dispose();

ImageIO.write(img, "png", new File("Clipped.png"));