public static void main(String[] args) throws InterruptedException {
    TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
    DateFormat fmt = new SimpleDateFormat("dd-MM-yy HH:mm:ss zz");

    Calendar cal = Calendar.getInstance();
    cal.set(2013, 10, 03, 0, 59, 59);
    System.out.println(fmt.format(cal.getTime()));

    cal.set(2013, 10, 03, 1, 0, 0);
    System.out.println(fmt.format(cal.getTime()));
}