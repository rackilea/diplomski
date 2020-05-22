@RunWith(Enclosed.class) // needed for working well with Ant
public class MyClassTests {
    public static class Programmatic {
        @Test
        public void myTest(){
            // test something here
        }
    }

    @RunWith(Parameterized.class)
    public static class DataDriven {
        @Parameters
        public static Collection<Object[]> getParams() {
            return Collections.emptyList();
        }

        private String data;
        public DataDriven(String testName, String data){
            this.data = data;
        }
        @Test
        public void test() throws AnalyzeExceptionEN{
            // test data string here
        }
    }
}