private static void createFile() {
  Writer out = null;
  long start = System.nanoTime();
  try {
    out = new BufferedWriter(new FileWriter(IN_FILE));
    Random r = new Random();
    for (int i = 0; i < SIZE; i++) {
      out.write(CHARS[r.nextInt(CHARS.length)]);
    }
  } catch (IOException e) {
    throw new RuntimeException(e);
  } finally {
    safeClose(out);
    long end = System.nanoTime();
    System.out.printf("Created %s size %,d in %,.3f seconds%n",
      IN_FILE, SIZE, (end - start) / 1000000000.0d);
  }
}