public static void listFilesAndFilesSubDirectories(String directoryName){
    File directory = new File(directoryName);
    //get all the files from a directory
    File[] fList = directory.listFiles();
    for (File file : fList){
        if (file.isFile()){
            System.out.print(file.getAbsolutePath());
            try(FileInputStream fis=new FileInputStream(file)){
                System.out.println(" - MD5: "+DigestUtils.md5Hex(IOUtils.toByteArray(fileInputStream)));
            }catch(Exception ex){
                System.out.println(" - Error: "+ex);
            }
        } else if (file.isDirectory()){
            listFilesAndFilesSubDirectories(file.getAbsolutePath());
        }
    }
}