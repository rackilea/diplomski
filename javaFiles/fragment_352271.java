for (int n = 1; n <= 4; n++) {
    String filePath = String.format("/saves/save%d.sav", n);
    File checkFile = new File(filePath);
    if (!checkFile.exists()) {
       try {
           checkFile.createNewFile();
           // If you want to write content to the file, do it here...
       } catch (IOException e) {
           e.printStackTrace();
       }
    } 
}