public static List<String> fileList(String directory) {
    List<String> fileNames = new ArrayList<>();
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
        for (Path path : directoryStream) {
            fileNames.add(path.toString());
        }
    } catch (IOException ex) {}
    return fileNames;
}