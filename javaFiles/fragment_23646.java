static public List<File> getDirs(File parent, int level){
    List<File> dirs = new ArrayList<File>();
    File[] files = parent.listFiles();
    if (files == null) return dirs; // empty dir
    for (File f : files){
        if (f.isDirectory()) {
             if (level == 0) dirs.add(f);
             else if (level > 0) dirs.addAll(getDirs(f,level-1));
        }
    }
    return dirs;
}