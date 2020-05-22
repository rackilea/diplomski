FileSystemView fileSystemView = FileSystemView.getFileSystemView();
for (File file : fileSystemView.getRoots()) {
    System.out.println("Root: " + file);
    for (File f : file.listFiles()) {
        if (f.isDirectory()) {
            System.out.println("Child: " + f);
        }
    }
}