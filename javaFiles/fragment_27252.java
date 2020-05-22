import java.util.Calendar;

public class DaysLeft {
    public static void main(String args[]) {
        Calendar cal = Calendar.getInstance();

        int max_days = cal.getMaximum(Calendar.DAY_OF_YEAR);
        int today = cal.get(Calendar.DAY_OF_YEAR);
        int days_left = max_days - today;

        System.out.format("We have a maximum of %d days this year.\n", max_days);
        System.out.format("Today is day number %d.\n", today);
        System.out.format("That means we have %d days left this year.\n",days_left);
    }       
}