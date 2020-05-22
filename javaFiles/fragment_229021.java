public static void process(File aFile){
    if (aFile.isFile()) {
        System.out.println("File name:" + aFile.getAbsolutePath());
    } else if (aFile.isDirectory()) {
        if(aFile.isHidden()){
            System.out.println(aFile.getAbsolutePath()+"folder is hidden");
        }
        File[] listOfFiles = aFile.listFiles();
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++)
                process(listOfFiles[i]);
        }
    }
}