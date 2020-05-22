public static void main(String[] args) {
    Date nextSetDate = getTodayAtMidnight();
    System.out.println(nextSetDate);
    Date now = new Date();
    System.out.println(now.after(nextSetDate));
}
public static Date getTodayAtMidnight() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_YEAR, 1);
        return c.getTime();
}