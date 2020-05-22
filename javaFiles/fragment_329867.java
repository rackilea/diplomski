import java.time.LocalDate;
import java.time.Period;

public class DatesComparison {

    public static void main(String[] args) {
        String date1= "2017-06-13";
        String date2= "2017-06-27";




        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);

        Period intervalPeriod = Period.between(localDate1, localDate2);

        System.out.println("Difference of days: " + intervalPeriod.getDays());  // Difference of days: 14
        System.out.println("Difference of months: " + intervalPeriod.getMonths());  // Difference of months: 0
        System.out.println("Difference of years: " + intervalPeriod.getYears());  // Difference of years: 0
    }
}