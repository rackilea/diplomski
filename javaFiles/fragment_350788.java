private static List<FileObject> getAllFilePaths(String rootDir, List<FileObject> helper) {
    File directory = new File(rootDir);
    System.out.println("rootDir: "+rootDir);
    //get all files and directories
    File[] allFiles = directory.listFiles();
    for (File file : allFiles) {
        if (file.isFile()) {
            System.out.println("If file: "+file.getName());
            //if it's a file add it to results

            FileObject fo=new FileObject(); // < Instantiate the FileObject here

            fo.setPath(file.getAbsolutePath());
            fo.setName(file.getName());
            helper.add(fo);
        } else if (file.isDirectory()) {
            System.out.println("else if: "+file.getName());
            //is it's a directory do the method again and add to to results
            //fo.setPath(file.getAbsolutePath());
            //fo.setName(file.getName());
            //results.add(fo);
            getAllFilePaths(file.getAbsolutePath(),helper);
        }
    }
    return helper;
}