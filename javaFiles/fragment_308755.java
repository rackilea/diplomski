// Paint image.
Graphics2D g2d = bi.createGraphics();
g2d.setColor(Color.WHITE);
g2d.fillRect(0, 0, size, size);
g2d.setComposite(AlphaComposite.SrcOver);
g2d.drawImage(srcImage, tx, null);