@RunWith(PowerMockRunner.class)
@PrepareForTest({ Singleton.class, Mock1.class, Mock2.class })
public class SingletonTestCase {
  private static Mock1 mock1 = PowerMockito.mock(Mock1.class);
  private static Mock2 mock2 = PowerMockito.mock(Mock2.class);

  @Before
  public void before() {
    PowerMockito.whenNew(Mock1.class).withNoArguments().thenReturn(mock1);
    PowerMockito.when(mock1.getMock2()).thenReturn(mock2);
    PowerMockito.when(mock2.method1("A", "B", "C")).thenReturn("D");
    PowerMockito.when(mock2.method1("B", "C", "D")).thenReturn("E");
  }

  @After
  public void after() {
    Mockito.reset(mock1);
    Mockito.reset(mock2);
  }

  public void testSingleton1() {
    Singleton singleton = Singleton.getInstance();
    assertEquals("D", singleton.method1("A", "B", "C"));

    Mockito.verify(mock1, Mockito.times(1)).getMock2();
    Mockito.verify(mock2, Mockito.times(1)).method1("A", "B", "C");
  }

  public void testSingleton2() {
    Singleton singleton = Singleton.getInstance();
    assertEquals("E", singleton.method1("B", "C", "D"));

    Mockito.verify(mock1, Mockito.times(1)).getMock2();
    Mockito.verify(mock2, Mockito.times(1)).method1("B", "C", "D");
  }
}