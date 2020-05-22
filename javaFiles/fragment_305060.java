final BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);    

Graphics2D g = dst.createGraphics();
g.drawImage(src, x1, y1, x2, y2, null);
g.dispose();

ImageIO.write(dst, "PNG", new FileOutputStream("dst.png"));