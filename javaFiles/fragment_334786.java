public class Example {
    File output;
    @Before public void createOutputFile() {
          output= new File(...);
    }
    @Test public void something() {
          ...
    }
    @After public void deleteOutputFile() {
          output.delete();
    }
 }