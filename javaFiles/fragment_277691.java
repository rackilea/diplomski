import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date_Difference {

    public static void main(String[] args) {

        long daysBetween = ChronoUnit.DAYS.between(LocalDate.of(1999, 12, 22), LocalDate.of(2019, 01, 31));

        System.out.println(daysBetween);

    }

}