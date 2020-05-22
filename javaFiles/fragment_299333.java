import java.util.GregorianCalendar;
public class CalTest {
    public static void main(String[] argv) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, 8);
        gc.set(GregorianCalendar.MONTH, GregorianCalendar.JUNE);
        gc.set(GregorianCalendar.YEAR, 2010);
        System.out.println(gc.get(GregorianCalendar.DAY_OF_YEAR));
}