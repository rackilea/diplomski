private String input;
private String output;
private boolean expectedResult;

@Parameters
 public static Collection<Object[]> data() {
   Object[][] data = {
        {"1", "1.00", true}               //return true
       ,{"1.", "1.00", true}             //return true
        ,{"1.0", "1.00", true}            //return true
        ,{"1.00", "1.00", true}           //return true
        ,{"1.000", "1.000", false}         //return false
        ,{"m","m", false}                  //return false
    };
   return Arrays.asList(data);
 }