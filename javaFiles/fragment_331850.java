String[] cmd = {"java", "-jar", currDir};
try {
  Runtime.getRuntime().exec(cmd);
} catch (IOException e1) {
  e1.printStackTrace();
}