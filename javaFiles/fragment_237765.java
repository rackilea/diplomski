public class TestTest {

public TestTest() {
    String dateString = "09/25/2012 08:47:46.983";

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss.SSS");

    try {
        Date date = dateFormat.parse(dateString);

        System.out.println("Date is: " + date.getTime());
    } catch (ParseException ex) {
        Logger.getLogger(TestTest.class.getName()).log(Level.SEVERE, null, ex);
    }


}

public static void main(String[] args) {
    TestTest test = new TestTest();
}

}