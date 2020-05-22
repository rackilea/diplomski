public static boolean isCacheFile(File f) {
    while (f.getParentDir()!=null) {
       f = f.getParentDir();
       if (f.equals(cacheDir)) {
           return true;
       }
    }
    return false;
}