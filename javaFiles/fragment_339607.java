public class Test {
public static void main(final String[] args) {
    Date date = new Date();
    System.out.println(date);
    // Adding 30 days to current time
    System.out.println(30 * 24 * 60 * 60 * 1000); // it will print -1702967296
    long longDate = (date.getTime() + TimeUnit.DAYS.toMillis(30));
    System.out.println(TimeUnit.DAYS.toMillis(30));
    date = new Date(longDate);
    System.out.println(date);
 }
}