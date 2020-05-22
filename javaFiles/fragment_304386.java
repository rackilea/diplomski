int upArrayIndex = 0, downArrayIndex = 0,
   leftArrayIndex = 0, rightArrayIndex = 0;
for (String file : fileName) {
  String path = PATH + file + EXT;

  if (file.startsWith("u")) {
    up[upArrayIndex++] = ImageIO.read(new File(path));
  } else if(file.startsWith("d")) {
    down[downArrayIndex++] = ImageIO.read(new File(path));
  } else if (file.startsWith("l")) {
    left[leftArrayIndex++] = ImageIO.read(new File(path));
  } else if (file.startsWith("r")) {
    right[rightArrayIndex++] = ImageIO.read(new File(path));
  }
}