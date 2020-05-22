public static void main(String[] args) throws IOException {
    Path startingDir = Paths
        .get("C:\\");
    Files.walkFileTree(startingDir, new FindJavaVisitor());
  }

  private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

      if (file.toString().contains("non-existent-playlist.m3u")) {
        System.out.println(file.getFileName());
      }
      return FileVisitResult.CONTINUE;
    }
  }