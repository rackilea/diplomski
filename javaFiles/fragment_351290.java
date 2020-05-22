public ImageIcon loadIcon(String iconName) throws IOException {
  ClassLoader loader = this.getClass().getClassLoader();
  BufferedImage icon = 
  ImageIO.read(loader.getResourceAsStream(iconName));
  return new ImageIcon(icon);
}