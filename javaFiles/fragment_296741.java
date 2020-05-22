public static void main(String[] args) {
    String path = "c:\\temp";
    Pattern filePattern = Pattern.compile("(?i).*\\.xml$");
    searchFolder(path, filePattern);
}

public static void searchFolder(String searchPath, Pattern filePattern){
    File dir = new File(searchPath);
    for(File item : dir.listFiles()){
        if(item.isDirectory()){
            //recursively search subdirectories
            searchFolder(item.getAbsolutePath(), filePattern);
        } else if(item.isFile() && filePattern.matcher(item.getName()).matches()){
            processFile(item);
        }
    }
}

public static void processFile(File aFile){
    String filename = aFile.getAbsolutePath();
    String txtFilename = filename.substring(0, filename.lastIndexOf(".")) + ".txt";
    //Do your xml file parsing and write to txtFilename
}