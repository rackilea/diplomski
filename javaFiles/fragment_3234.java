public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        for (String line : new FileSorter(new File(Main.class.getResource("test.txt").toURI()).toPath())) {
            System.out.println(line);
        }
    }

    static class FileSorter implements Iterable<String> {
        private final Path path;

        FileSorter(Path path) {
            this.path = path;
        }

        @Override
        public Iterator<String> iterator() {
            try {
                return Files.lines(path)
                        .sorted()
                        .iterator();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}