public void walkDir(String pathname) {
    File d = new File(pathname);
    recursiveList.add(d);
    if(d.isDirectory()) {
        for(String f : d.list()) {  // <-- here
            walkDir(f);             // <--
        }
    }
}