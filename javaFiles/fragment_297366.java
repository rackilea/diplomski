public ImagePanel(String imgpath) {
  try {
    image = ImageIO.read(new File(imgpath));
  }
  catch (IOException e) {
    throw new Error(e);
  }
}