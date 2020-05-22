private Stream<Path> getPaths(/** cobDir, pattern, format */){
  return Files.find(cobDir, 1,
              (path, attrs) -> attrs.isRegularFile()
                      &&
    path.getFileName().toString().toLowerCase().startsWith(pattern)
                      && path.toString().toLowerCase().endsWith(format))
}