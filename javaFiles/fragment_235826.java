import java.time.*;
import java.time.format.*;

public class DayOfWeek {
    public static void main(String[] args){
        System.out.println("Enter the date (Format: MM DD YYYY) :");
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM dd yyyy");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        LocalDate date = LocalDate.parse(line, parser);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        System.out.println(formatter.format(date).toUpperCase());
    }
}