Path file = "yourfile";
// open file
try (InputStream in = Files.newInputStream(file);
    BufferedReader reader =
      new BufferedReader(new InputStreamReader(in))) {
    String line = null;
    intArr = new int[10]; // bad code could fail if file has more than 10
    int i = 0;
    while ((line = reader.readLine()) != null) {
        intArr[i++] = Integer.parseInt(line); // parse String to int
    }
} catch (IOException x) {
    System.err.println(x);
}