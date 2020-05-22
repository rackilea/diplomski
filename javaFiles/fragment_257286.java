@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class Chars {
  static String string = "12345678901234567890"; static {
    for (int i = 0; i < 10; i++) string += string;
  }

  @GenerateMicroBenchmark
  public void newChar() {
    int len = string.length();
    for (int i = 0; i < len; i++) new Character(string.charAt(i));
  }

  @GenerateMicroBenchmark
  public void justChar() {
    int len = string.length();
    for (int i = 0; i < len; i++) Character.valueOf(string.charAt(i));
  }
}