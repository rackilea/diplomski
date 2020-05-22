try {
      Files.walkFileTree(Paths.get("somePath"), new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              System.out.println("visitFile: " + file);
              return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFileFailed(Path file, IOException ex) throws IOException {
              System.out.println("visitFileFailed: " + file + " because of " + ex);
              return FileVisitResult.CONTINUE;
          }
          // etc... you can add postVisit...
      });
} catch (IOException e) {
      ...
}