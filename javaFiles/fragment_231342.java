public List<String> getLanguages(String directoryPath) throws IOException {
  List<String> languages = new ArrayList<>();
  try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(directoryPath))) {
    for (Path filePath : paths) {
      try (DirectoryStream<Path> filePaths = Files.newDirectoryStream(filePath, "strings.xml")) {
        languages.addAll(getValues(filePaths));
      }
    }
  }
  return languages;
}

private List<String> getValues(DirectoryStream<Path> paths) {
  return StreamSupport.stream(paths.spliterator(), false)
      .map(path -> path.getFileName().toString())
      .filter(fileName -> fileName.startsWith("values-"))
      .flatMap(fileName -> Arrays.stream(fileName.split("-")))
      .collect(Collectors.toList());
}