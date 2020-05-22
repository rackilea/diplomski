public static void main(String[] args) {
  new Test();
}

public Test() {
  JFileChooser jfc = new JFileChooser();
  File loc = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
  jfc.setCurrentDirectory(loc);
  jfc.showOpenDialog(null);
}