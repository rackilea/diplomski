import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tester {
    public static void main(String[] argv) {
        java.util.Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Lenient
        try {
            date = sdf.parse("40/02/2013");
            System.out.println("Lenient date is :                  "+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Rigorous
        sdf.setLenient(false);

        try {
            date = sdf.parse("40/02/2013");
            System.out.println("Rigorous date (won't be printed!): "+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}