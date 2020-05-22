class DateTest {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("d MMM yyyy G, HH:mm:ss.S Z");

        System.out.println(df.format(new Date(Long.MIN_VALUE)));
        System.out.println(df.format(new Date(0)));
        System.out.println(df.format(new Date(Long.MAX_VALUE)));
    }
}