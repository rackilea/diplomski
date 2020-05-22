String path = "/tmp/timeline.txt";
try(Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
    lines.limit(10).forEachOrdered(new Consumer<String>() {
        int counter = 0;
        public void accept(String line) {
            System.out.println("Line " + counter++ + ": " + line.trim());
        }
    });
} catch (IOException e) {
    e.printStackTrace();
}