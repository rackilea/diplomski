public static String getNewFileName(String filename) throws IOException {
    File aFile = new File(filename);
    int fileNo = 0;
    String newFileName = "";
    if (aFile.exists() && !aFile.isDirectory()) {


        //newFileName = filename.replaceAll(getFileExtension(filename), "(" + fileNo + ")" + getFileExtension(filename));

        while(aFile.exists()){
            fileNo++;
            aFile = new File("images(" + fileNo + ").txt");
            newFileName = "images(" + fileNo + ").txt";
        }


    } else if (!aFile.exists()) {
        aFile.createNewFile();
        newFileName = filename;
    }
    return newFileName;
}