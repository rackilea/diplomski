ArrayList<String> findSongs(String rootPath) {
    ArrayList<String> fileList = new ArrayList<>();
    try{
       File rootFolder = new File(rootPath);
       File[] files = rootFolder.listFiles(); //here you will get NPE if directory doesn't contains  any file,handle it like this.
       for (File file : files) {
         if (file.isDirectory()) {
               if (findSongs(file.getAbsolutePath()) != null) {
                    fileList.addAll(findSongs(file.getAbsolutePath()));
                } else {
                    break;
                }
         } else if (file.getName().endsWith(".mp3")) {
             fileList.add(file.getAbsolutePath());
         }
    }
    return fileList;
    }catch(Exception e){
       return null;
    }
}