ZipInputStream zis;
    ZipEntry zipEntry;
    try {
        zis = new ZipInputStream(filePart.getInputStream());
        zipEntry = zis.getNextEntry(); 
    } catch (IOException ioExc) {
        //do something;
    }
while(zipEntry != null){ //if you run me I will infinitely loop!
    String fileName = zipEntry.getName();
    System.out.println("I am the directory! " +zipEntry.isDirectory() + " " + zipEntry.getName());

}