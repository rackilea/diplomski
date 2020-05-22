import java.util.Calendar;


public class CalTest
{
    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, 1995);
        System.out.println(cal.get(Calendar.YEAR));

        cal.add(Calendar.YEAR, 1);
        System.out.println(cal.get(Calendar.YEAR));

        cal.add(Calendar.YEAR, 1);
        System.out.println(cal.get(Calendar.YEAR));
    }
}