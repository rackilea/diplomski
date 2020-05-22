public class Test {

public static void main(String[] args) {
    Calendar cal = GregorianCalendar.getInstance();
    System.out.println("Minutes : "+ cal.get(Calendar.MINUTE));
    System.out.println("Seconds :" + cal.get(Calendar.SECOND));
    cal.add(Calendar.SECOND, 50);
    System.out.println("Minutes : "+ cal.get(Calendar.MINUTE));
    System.out.println("Seconds :" + cal.get(Calendar.SECOND));
}