public class MomentInTime {

private static Calendar calendarInstance = Calendar.getInstance();

public static long inMillis() {
    calendarInstance.clear();
    calendarInstance.set(2012, 10, 1, 19, 9);
    return calendarInstance.getTimeInMillis();
}

public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
        System.out.println(inMillis()/1000);
        Thread.sleep(300);
    }
}
}