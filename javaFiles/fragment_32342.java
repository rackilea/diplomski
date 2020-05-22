// create input stream that reads line by line, create output writer
try (Stream<String> input = Files.lines(Paths.get("input.txt"));
     PrintWriter output = new PrintWriter("output.txt", "UTF-8")){
    // compress each input stream line, and print to output
    input.map(s -> compress(s)).forEachOrdered(output::println);
} catch (IOException e) {
    e.printStackTrace();
}