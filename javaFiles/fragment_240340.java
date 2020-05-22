List<File> listFiles = (List<File>) Arrays.asList(dir.listFiles());
listFiles.parallelStream().forEach((file)->{
    String filename = file.getName();
    if(file.lastModified() < purgeTime){
        if(!file.delete()){
            System.out.println("can't delete file: "+filename);
        }else{
            System.out.println("deleted: "+filename);
        }
    }
});