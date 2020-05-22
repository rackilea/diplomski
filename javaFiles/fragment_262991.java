public class DateFormatTest {
    public static void main(String... args) {
        SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
        String eDate ="04/26/2013";
        Date eDDte;
        try {
            eDDte = df2.parse(eDate);
            System.out.println("Date: " + df3.format(eDDte));
        } catch(ParseException e){
            e.printStackTrace();
        }
    }
}