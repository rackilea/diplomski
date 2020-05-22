public void getListOfFolders(String rootPath) {
    List<String> folders = new LinkedList<String>();
    getFolders(rootPath, folders);
    // Now folders got everything you need.
}

public void getFolders(String directoryName, List<String> folders) {
    File directory = new File(directoryName);
    File[] fList = directory.listFiles();
    for (File file : fList) {
        if (file.isDirectory()) {
            folders.add(file.getAbsolutePath());
            getFolders(file.getAbsolutePath(), folders);
        }
    }
}