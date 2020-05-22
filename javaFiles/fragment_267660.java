for(;;){
for(String str : path){
    Path dir = Paths.get(str);
    new WatchDir(dir, true).processEvents();
}
}