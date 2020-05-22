public class RockPaperScissorsTest() {
  @Rule
  public StandardOutputStreamLog log = new StandardOutputStreamLog();

  @Rule
  public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

  @Test
  public void test1() {
    systemInMock.provideText("<test input>");
    RockPaperScissors.main(null);
    assertTrue(log.getLog().contains("<expected output>"));
  }

  @Test
  public void test2() {
    systemInMock.provideText("<another test input>");
    RockPaperScissors.main(null);
    assertTrue(log.getLog().contains("<expected output>"));
  }
}