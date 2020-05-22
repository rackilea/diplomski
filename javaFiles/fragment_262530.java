import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        Date parsed = format.parse("Fri Nov 16 00:00:00 CXT 2012");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
    }
}