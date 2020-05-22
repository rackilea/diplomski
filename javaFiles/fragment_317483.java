String path = "/tmp/timeline.txt";
try(Stream<String> lines = numberedLines(Paths.get(path), Charset.defaultCharset())) {
    lines.skip(10).limit(10).forEachOrdered(System.out::println);
} catch(IOException e) {
    e.printStackTrace();
}