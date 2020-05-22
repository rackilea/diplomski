public static ArrayList<File> listFilesWrapper(File dir){
     listFiles (dir , new ArrayList<File>());

   }

 public static ArrayList<File> listFiles(File dir,ArrayList<File> classFileList) {


if (!dir.isDirectory() || !dir.exists()) 
    return null;
for (File file : dir.listFiles()) {
    classFileList.add(file);
    listFiles(file , classFileList);
}
return classFileList;
}