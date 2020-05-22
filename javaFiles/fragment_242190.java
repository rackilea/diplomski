public class FilesTest {
    public static void main(String[] args) {
        final String pwd = System.getProperty("user.dir");
        System.out.println("Working Directory = " + pwd);
        Path dir = Paths.get(pwd);
        System.out.println("Files.walk");
        try {
            Files.walk(dir, 1).forEach(path -> FilesTest.doSomething("walk", path));
        } catch (IOException e) {
            logException("walk", e);
        }
        System.out.println("Files.walkFileTree");
        try {
            Files.walkFileTree(dir, Collections.emptySet(), 1, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    doSomething("visitFile", file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    logException("visitFile", exc);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            logException("walkFileTree", e);
        }
        System.out.println("Files.list");
        try {
            Files.list(dir).forEach(path -> FilesTest.doSomething("dir", path));
        } catch (IOException e) {
            logException("dir", e);
        }
    }

    private static void logException(String title, IOException e) {
        System.err.println(title + "\terror: " + e);
    }

    private static void doSomething(String title, Path file) {
        System.out.println(title + "\t: " + file);
    }
}