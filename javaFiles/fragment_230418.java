if (!myFile.exists()) {
    System.out.println("myFile is: " + myFile.getAbsolutePath());
    if (!myFile.getParentFile().exists()) {
        myFile.getParentFile().mkdirs();
    }
    myFile.createNewFile();
    myFileWriter.write("0"); // Configured to write to myFile
}