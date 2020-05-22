public static ImageIcon getImage1() {
  try {
      return new ImageIcon(ImageIO.read(new File("imatges/Mapa.png")))
  } catch (IOException e2) {
      e2.printStackTrace();
  }
  return null;
}