public static void main(String[] args) throws IOException {
    FileSystemView fsv = FileSystemView.getFileSystemView();
    File outFile = new File(fsv.getHomeDirectory() + "/output.txt"); // file into desktop dir

    System.out.println(outFile.getAbsolutePath()); // print it's location in console
    ...
}