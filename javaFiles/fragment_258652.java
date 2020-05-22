BufferedImage bim=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
Graphics g=bim.getGraphics();
g.setColor(Color.white);
g.fillRect(0, 0, w, h);
g.setColor(Color.black);
g2.fillArc(x, y, 2*w/16, 2*h/16, 270, 250);
int[] pix=bim.getRGB(0, 0, w, h, null, 0, w);
Vector v=measureArea(pix);