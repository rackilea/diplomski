private static void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
   ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
   Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
       public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
           zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
           Files.copy(file, zos);
           zos.closeEntry();
           return FileVisitResult.CONTINUE;
        }
    });
    zos.close();
 }