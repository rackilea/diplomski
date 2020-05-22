import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main {
    public static void main(String args[]) {
        String date1Str = "11/11/2019";// assuming it is in dd/MM/yyyy format
        String date2Str = "Fri Oct 11 17:28:07 IST 2019";

        Date date1 = null, date2 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1Str);
            date2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(date2Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 != null && date2 != null) {
            if (date1.compareTo(date2) > 0)
                System.out.println(date1Str + " comes after " + date2Str);
            else if (date1.compareTo(date2) == 0)
                System.out.println(date2Str + " comes after " + date1Str);
            else
                System.out.println(date1Str + " and " + date2Str+" fall on the same date & time");
        }
    }
}