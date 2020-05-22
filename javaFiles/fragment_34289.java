private static String DATE_PART = "dd/MM/yyyy";
private static String HOUR_PART = "HH:mm";
private static java.text.DateFormat FORMAT = 
    new java.text.SimpleDateFormat(DATE_PART + " " + HOUR_PART);
private static java.text.DateFormat HOUR_FORMAT = 
    new java.text.SimpleDateFormat(HOUR_PART);
private static java.text.DateFormat DATE_FORMAT = 
    new java.text.SimpleDateFormat(DATE_PART);

public static Date fromStrings(String date, String time) {
    StringBuilder sb = new StringBuilder(date);
    sb.append(" ").append(time);
    try {
        return FORMAT.parse(sb.toString());
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
}
public static void main(String[] args) {
    String date ="09/01/2014";
    String time ="16:05";
    java.util.Date dt = fromStrings(date, time);
    System.out.println(dt);
    System.out.println(DATE_FORMAT.format(dt));
    System.out.println(HOUR_FORMAT.format(dt));
}