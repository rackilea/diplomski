public class GetProperty
{
  static char[] ary = new char[1];
  @GenerateMicroBenchmark public void everyTime() {
    for (int i = 0; i < 100_000; i++) ary[0] = System.getProperty("line.separator").charAt(0);
  }
  @GenerateMicroBenchmark public void cache() {
    final char c = System.getProperty("line.separator").charAt(0);
    for (int i = 0; i < 100_000; i++) ary[0] = (char)(c | ary[0]);
  }
}