File source = new File(""C://Desktop//filename.txt");
File dest = new File("C://temp//cache-filename.txt");
try {
    FileUtils.copyDirectory(source, dest);
} catch (IOException e) {
    e.printStackTrace();
}