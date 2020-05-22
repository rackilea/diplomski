public class DateOfBirth {

    public static final double DAYS_IN_YEAR = 365.242;
    public static final double DAYS_IN_MONTH = DAYS_IN_YEAR / 12d;

    public static void main(String[] args) {
        int day = 8;
        int month = 3;
        int year = 1972;

        // Number of days...
        double time = toDays(year, month, day);
        // One day less of the year 2015...
        double today = toDays(2014, 4, 16); // today...

        double diff = today - time;

        int years = (int)Math.round(diff / DAYS_IN_YEAR);
        double over = diff % DAYS_IN_YEAR;
        int months = (int)(over / DAYS_IN_MONTH);
        over = over % DAYS_IN_MONTH;
        int days = (int) over;

        System.out.println(years + " years, " + months + " months, " + days + " days");           
        System.out.println(NumberFormat.getNumberInstance().format(diff / DAYS_IN_YEAR));            
    }

    public static double toDays(int year, int month, int day) {            
        return (year * DAYS_IN_YEAR) + (month * DAYS_IN_MONTH) + day;            
    }

}