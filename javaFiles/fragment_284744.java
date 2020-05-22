public class AllFilesLines {
  public static void main(String[] args) {
      File[] files = …

      Arrays.stream(files).flatMap(AllFilesLines::lines)
            .forEach(System.out::println);
  }
  static Stream<String> lines(File f) {
      try { return Files.lines(f.toPath()); }
      catch (IOException e) { throw new UncheckedIOException(e); }
  }
}