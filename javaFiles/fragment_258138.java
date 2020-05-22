public void processFile(String file) {
   File root = new File(file);
   File[] list = root.listFiles();
   this.numFiles = 0;
   this.numDirectories = 0;

   for (File f : list) {
       if (f.isDirectory()) {
           numDirectories++;
           processFile(f.getAbsolutePath());
       } else if (f.isFile()) {
           numFiles++;
       }
   }
}

public void displayStatistics() {
    System.out.format("Total of file: %d\nTotal of directories: %d\n", numFiles, numDirectories);
}