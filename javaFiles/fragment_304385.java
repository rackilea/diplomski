for (String file : fileName) {
  String path = PATH + file + EXT;

  BufferedImage array = null;
  if (file.startsWith("u")) {
    array = up;
  } else if(file.startsWith("d")) {
    array = down;
  } else if (file.startsWith("l")) {
    array = left;
  } else if (file.startsWith("r")) {
    array = right;
  }

  for (int i = 0; i < arrayLength; i++) {
    array[i] = ImageIO.read(new File(path));
  }
}