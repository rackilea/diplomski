Map<File,Integer> map = new HashMap<>();
for(File f : folderA){
    Integer count = 0;
    if(map.get(f)==null){
        map.put(f,1);
    }else{
        count = map.get(f);
        map.put(f,++count);
    }
}