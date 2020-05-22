@RunWith(Parameterized.class)
public class QuickTest {

  private static Object expensiveObject;  
  private final int value;

  @BeforeClass
  public static void before() {
    System.out.println("Before class!");
    expensiveObject = new String("Just joking!");
  }


  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { { 1 }, { 2 } });
  }      

  public QuickTest(int value) {
    this.value = value;
  }

  @Test
  public void test() {
    System.out.println(String.format("Ran test #%d.", value));
    System.out.println(expensiveObject);
  }
}