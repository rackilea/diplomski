// format should be "jpg", "gif", etc.
public void saveIconToFile(ImageIcon icon, String filename, String format) throws IOException {
  BufferedImage image = iconToImage(icon);
  File output = new File(filename);
  ImageIO.write(bufferedImage, format, outputfile);
}

public BufferedImage iconToImage(ImageIcon icon) {
  BufferedImage bi = new BufferedImage(
      icon.getIconWidth(),
      icon.getIconHeight(),
      BufferedImage.TYPE_INT_ARGB);
  Graphics g = bi.createGraphics();

  // paint the Icon to the BufferedImage.
  icon.paintIcon(null, g, 0,0);
  g.dispose();

  return bi;
}