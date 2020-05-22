public static void main(String[] args) {
  if (!new File(IN_FILE).exists()) {
    createFile();
  }
  charRead(true);
  charRead(true);
  charRead(false);
  charRead(false);
  blockRead(true);
  blockRead(true);
  blockRead(false);
  blockRead(false);
}