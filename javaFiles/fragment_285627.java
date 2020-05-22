public boolean checkFileCountInEachFolder(final int nbMessages) {

    File folder = new File(AppProperties.getInstance().get("path"));

    File[] subFolders = folder.listFiles(new FileFilter() {
        @Override
        public boolean accept(final File f) {
            return f.isDirectory();
        }
    });

    int nbFolders = subFolders.length;
    int minOccurences = nbMessages / nbFolders;
    int maxOccurences = minOccurences + 1;

    int totalCount = 0;

    for (int i = 0; i < subFolders.length; i++) {
        File file = subFolders[i];

        int fileCount = listFiles(file, new ArrayList<File>()).size();
        if (fileCount < minOccurences || fileCount > maxOccurences) {
            return false;
        }

        totalCount += fileCount;

    }

    return (totalCount == nbMessages);

}