public class DateFormatTest {
    public static String DATE_FORMAT="dd MMM yyyy HH:mm:ss z";
     public static String CURRENT_DATE_STRING ="31 October 2011 14:19:56 GMT";

    public static void main(String[] args) throws ParseException {
         DateFormat dateFormat =  new SimpleDateFormat(DATE_FORMAT);
         //dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
         Date d= dateFormat.parse(CURRENT_DATE_STRING);
         dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
         System.out.println(dateFormat.format(d));
    }
}