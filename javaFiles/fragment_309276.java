import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParsingLocalDate {

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate d = LocalDate.parse("04-12-2019", fmt);
        System.out.println(d);  // 2019-12-04
    }
}