// create the new image, canvas size is the max. of both image sizes (a and b are ImageIcons)
int w = a.getIconWidth();
int h = a.getIconHeight();
BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

// paint both images, preserving the alpha channels
Graphics g = combined.getGraphics();
g.drawImage(a.getImage(), 0, 0, null);
g.drawImage(b.getImage(), 0, 0, null);
ImageIcon result = new ImageIcon(combined);