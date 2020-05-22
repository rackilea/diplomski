public static void main(final String[] args) throws Exception{
    final File homeFolder = new File(System.getProperty("user.home"));
    final File[] subFolders = homeFolder.listFiles(new FileFilter(){

        private int ct = 0;

        @Override
        public boolean accept(final File pathname){
            return pathname.isDirectory() && ct++ < 5;
        }
    });
    System.out.println("Folders to check:" + Arrays.toString(subFolders));
    long accumulated = 0l;

    for(final File file : subFolders){
        accumulated += getFolderSize(file);
    }
    final long allAtOnce = getFolderSize(subFolders);
    final long withVarArgs =
        getFolderSize(subFolders[0], subFolders[1], subFolders[2],
            subFolders[3], subFolders[4]);
    System.out.println("Accumulated: " + accumulated);
    System.out.println("All at once: " + allAtOnce);
    System.out.println("With varargs: " + withVarArgs);
}