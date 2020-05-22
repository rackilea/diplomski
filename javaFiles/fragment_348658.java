public static void main(String[] args) throws Exception {
    final Path path = Paths.get("path", "to", "folder");
    final Path txt = path.resolve("myFile.txt");
    final Path csv = path.resolve("myFile.csv");
    final Charset utf8 = Charset.forName("UTF-8");
    try (
            final Scanner scanner = new Scanner(Files.newBufferedReader(txt, utf8));
            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv, utf8, StandardOpenOption.CREATE_NEW))) {
        while (scanner.hasNextLine()) {
            pw.println(scanner.nextLine().replace('|', ','));
        }
    }
}