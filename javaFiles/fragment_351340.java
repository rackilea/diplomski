public static ArrayList<File> listFolders(File folder) {
    ArrayList<File> subFolders = new ArrayList<>();
    File[] folders = folder.listFiles(new FileFilter() {

        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    });
    for(File subFolder : folders) {
        subFolders.addAll(listFolders(subFolder));
    }
    subFolders.addAll(Arrays.asList(folders));
    return subFolders;
}