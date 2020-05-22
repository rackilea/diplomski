public class Java7FileVisitorExample {

public void traverseFolder(Path start){
    try {
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {

            private int depth = -1;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println("preVisitDirectory(" + dir + ")");
                depth++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                if (depth > 0) {
                    return FileVisitResult.SKIP_SIBLINGS;
                }

                System.out.println("visitFile(" + file + ", " + attrs + "): depth == " + depth);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                if (e == null) {
                    depth--;
                    System.out.println("postVisitDirectory(" + dir + ")");
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }


            }
        });
    } catch (IOException ex) {
        Logger.getAnonymousLogger().throwing(getClass().getName(), 
                "traverseFolder", ex);
    }
}

public static void main(String... args) {
    Path start = Paths.get("/Book/Algorithm");
    new Java7FileVisitorExample().traverseFolder(start);
}