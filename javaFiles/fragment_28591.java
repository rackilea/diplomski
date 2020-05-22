File src = new File("src/main/resources/source/toBeCopied.txt");
File dest = new File("src/main/resources/dest/");
try {
  FileUtils.copyFileToDirectory(src, dest);
} catch (IOException e) {
  e.printStackTrace();
}