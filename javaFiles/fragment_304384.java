for (String file : fileName) {
  String path = PATH + file + EXT;

  for (int i = 0; i < arrayLength; i++) {
    if (file.startsWith("u")) {
      up[i] = ImageIO.read(new File(path));
    } else if(file.startsWith("d")) {
      down[i] = ImageIO.read(new File(path));
    } else if (file.startsWith("l")) {
      left[i] = ImageIO.read(new File(path));
    } else if (file.startsWith("r")) {
      right[i] = ImageIO.read(new File(path));
    }
  }
}