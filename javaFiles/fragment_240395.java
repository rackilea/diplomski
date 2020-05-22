private void getFile(String dirPath) {
  try {
    Files.find(Paths.get(dirPath), 1, (path, basicFileAttributes) -> (path.toFile().getName().contains("DAPI"))).forEach(
      dapiPath -> {
        Path gfpPath = dapiPath.resolveSibling(dapiPath.getFileName().toString().replace("DAPI", "GFP"));
        doSomething(dapiPath, gfpPath);
      });
  } catch (IOException e) {
    e.printStackTrace();
  }
}

//Dummy method does nothing yet.
private void doSomething(Path dapiPath, Path gfpPath) {
  System.out.println(dapiPath.toAbsolutePath().toString());
  System.out.println(gfpPath.toAbsolutePath().toString());
}