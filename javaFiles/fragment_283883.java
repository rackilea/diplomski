public static class UsesErrorCollectorTwice {
  @Rule
  public ErrorCollector collector= new ErrorCollector();

  @Test
  public void example() {
    String x = [..]
    collector.checkThat(x, not(containsString("a")));
    collector.checkThat(y, containsString("b"));             
  }
}