public static void createDirs(String path, int times) {
    int x;
    for(x=1; x < times+1; x++){
        path += File.separator + Integer.toString(x);
        new File(path).mkdir();
    }
}