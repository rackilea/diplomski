import java.util.Calendar;


public class test_cal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getLastTimeStampOfCurrentMonth(Calendar.AUGUST,2016));
    }
    public static long getLastTimeStampOfCurrentMonth(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);//leap year 29 Feb;)
        cal.set(Calendar.MONTH, month);
        cal.set(year,month, cal.getActualMaximum(Calendar.DAY_OF_MONTH), cal.getActualMaximum(Calendar.HOUR_OF_DAY),cal.getActualMaximum(Calendar.MINUTE),cal.getActualMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND,cal.getActualMaximum(Calendar.MILLISECOND));
        return cal.getTimeInMillis();
    }
}