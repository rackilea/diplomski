import java.time.*;
import java.time.format.*;
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
        LocalDate date = LocalDate.of(y, m, d);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        System.out.println(formatter.format(date).toUpperCase());
    }
}