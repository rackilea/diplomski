import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParsingDate {

    public static void main(String[] args) {
        DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        System.out.println(d);  // Wed Dec 04 11:24:35 CET 2019
        System.out.println(fmt.format(d)); // 04-12-2019
    }
}