@RunWith(Parameterized.class)
public class MyTestClass {
  @Parameters
  public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
          { "A", 1, "M", 1, "value1", "value2" },
          { "Q", 5, "Z", 10, "value3", "value4" },
      });
  }

  private String xValue;
  private int yValue;
  private String zValueString;
  private int zValueInt;
  private String expected1;
  private String expected2;

  public MyTestClass(String xValue, int yValue, String zValueString, int zValueInt, String expected1, String expected2) {
    this.xValue = xValue;
    this.yValue = yValue;
    this.zValueString = zValueString;
    this.zValueInt = zValueInt;
    this.expected1 = expected1;
    this.expected2 = expected2;
  }

  @Test
  public void test() {
    mockObjectX(xValue);
    mockObjectY(yValue);
    mockObjectZ(zValueString, zValueInt);

    myService.validate(expected1, expected2);
  }
}