public static void main(String[] args) {
    File master = new File("Master-part1.txt");
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(master))) {
        Path path = master.toPath();
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile().getName().equals("part1.txt")) {
                    append(file.toFile(), bw);
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
    } catch (IOException exp) {
        exp.printStackTrace();
    }
}

protected static void append(File file, BufferedWriter bw) throws IOException {

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String text = null;
        while ((text = br.readLine()) != null) {
            bw.write(text);
            bw.newLine();
        }
    } finally {
    }

}