public class TestSample {

    @Test(dataProvider = "dp")
    public void testMethod(Object object) {
        if (object instanceof String[]) {
            System.err.println("Incoming array was " + Arrays.toString((String[]) object));
        }
        if (object instanceof String) {
            System.err.println("Incoming string " + object);
        }

    }

    @DataProvider(name = "dp")
    public Object[][] getData() {
        return new Object[][]{
                {new String[]{"TestNG", "JUnit"}},
                {"Cedric Beust"}
        };
    }
}