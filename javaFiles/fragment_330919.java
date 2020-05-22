public class Main {

  private static final Pattern wordBreak = Pattern.compile("[\\p{Punct}\\s]+");

  public static Map<String, Long> generateConcordance(Stream<String> lines) {
    return lines
      .flatMap(wordBreak::splitAsStream)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static Map<String, Long> generateConcordance(String fileName) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
      return generateConcordance(lines);
    }
  }

  public static Map<String, Long> generateConcordance(InputStream in) {
    InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
    return generateConcordance(new BufferedReader(reader).lines());
  }

  public static void main(String[] args) {
    try
    {
      generateConcordance("SomeRandomFile.txt");
      generateConcordance(System.in);
    }
    catch (IOException e)
    {
      e.printStackTrace(System.err);
    }
  }
}