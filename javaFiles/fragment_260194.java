public class WidgetProcessorTest {
  private WidgetProcessor processor;
  private FizzChecker mockFizzChecker;

  @Before public void setUp() {
    processor = new WidgetProcessor();
    mockFizzChecker = Mockito.mock(FizzChecker.class);
    processor.setFizzChecker(mockFizzChecker);
  }

  @Test public void neverHasBuzz() {
    when(mockFizzChecker.hasMoreBuzz()).thenReturn(false);
    processor.process();
    // asserts
  }

  @Test public void hasFiveBuzzes() {
    when(mockFizzChecker.hasMoreBuzz())
        .thenReturn(true, true, true, true, false);
    processor.process();
    // asserts
  }
}