public void printAllJavaFiles(File directory) {
    if (directory.isDirectory()) {
        File[] subDirectories = directory.listFiles();

        for (File file : subDirectories) {
            printAllJavaFiles(file);
        }
    }else {
        printFile(directory);
    }
}