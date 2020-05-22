public class test {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        DateFormat weekdayNameFormat = new SimpleDateFormat("E", locale);
        String weekday = weekdayNameFormat.format(new Date());
        System.out.println(weekday.charAt(0));
    }

}