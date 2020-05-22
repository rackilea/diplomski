/*
 * Method to move a specific file from directory to another
 */
public static void moveFile(String source, String destination) {
    File file = new File(source);
    String newFilePath = destination + "\\" + file.getName();
    File newFile = new File(newFilePath);
    String fileName;
    String extention; 
    int fileNum;
    int cont;
    if (!newFile.exists()) {
        file.renameTo(new File(newFilePath));
    } else {
        cont = 1;
        while(newFile.exists()) {
            fileName = FilenameUtils.removeExtension(file.getName());
            extention = FilenameUtils.getExtension(file.getPath());
            System.out.println(fileName);
            newFile = new File(destination + "\\" + fileName + "(" + cont++ + ")" + extention);
        }
        newFile.createNewFile();
    }//End else
}