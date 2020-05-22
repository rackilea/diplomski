// BAD CODE: DON'T USE - KEEP READING
import java.text.*;
import java.util.*;

public class DayOfWeek {
    public static void main(String[] args){
        System.out.println("Enter the date (Format: MM DD YYYY) :");
        Scanner sc = new Scanner(System.in);
        String month = sc.next();
        String day = sc.next();
        String year = sc.next();
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int y = Integer.parseInt(year);
        // Note the changes here
        Date date = new Date(y - 1900, m - 1, d);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        System.out.println(sdf.format(date).toUpperCase());
    }
}