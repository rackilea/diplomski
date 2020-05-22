//Path valuesPath = Paths.get("VALUES_DIR", "values.txt");
Path valuesPath = Paths.get("./" + args[0]);

try {
  List<String> lines = Files.readAllLines(valuesPath, Charset.defaultCharset()));

  for (String line : lines) {     //print lines (or do whatever you need)
    System.out.println(line);
  }
} catch (IOException e) {
   e.printStackTrace();
}