public class A {
    private String s;

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
          new Object[] { "test-eclipselink-h1" },
          new Object[] { "test-eclipselink-h2" }
        };
      }

    @Factory(dataProvider = "dp")
    public A(String s) {
        System.out.println("Creating test class with " + s);
        this.s = s;
    }

    @Test
    public void test() {
        System.out.println("Test " + s);
    }
}