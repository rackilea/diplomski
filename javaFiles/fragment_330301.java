public static void main(String[] vargs) throws FileSystemException {
    FileSystemManager manager = VFS.getManager();
    FileObject root = manager.resolveFile("/home/me/test/vfsdir");

    List<FileObject> files = findFiles(root, new XMLSelector());
    files.stream().forEach(System.out::println);
}

public static List<FileObject> findFiles(FileObject root,FileSelector fileSelector) throws FileSystemException {
    List<FileObject> filesInDir = Arrays.asList(root.findFiles(fileSelector));
    FileObject[] zipFiles = root.findFiles(new ZipSelector());

    FileSystemManager manager = VFS.getManager();

    List<FileObject> filesInZips = new ArrayList<>();
    for (FileObject zip: zipFiles){
        FileObject zipRoot = manager.createFileSystem(zip);
        Stream.of(zipRoot.findFiles(fileSelector)).forEach(filesInZips::add);
    }

    return Stream.concat(filesInDir.stream(),filesInZips.stream()).collect(Collectors.toList());
}