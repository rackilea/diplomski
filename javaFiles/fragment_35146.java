public class FileVisitorTest {

    @Test
    public void test() throws Exception {
        String path = "D:\\downloads\\";
        findFiles(path,"apache", "Test");
    }

    public void findFiles(String path, String... keyWords) {
        try {
            Files.walkFileTree(Paths.get(path), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
                    return FileVisitResult.CONTINUE;
                }

                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    for (String keyWord : keyWords) {
                        if (path.getFileName() != null && path.getFileName().toFile().getName().contains(keyWord))
                            System.out.println("File name:" + path.getFileName());
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}