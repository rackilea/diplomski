public static void main (String[] args)
{
    SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy");
    parser.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date dt = parser.parse("Mon Mar 07 17:00:00 MST 2016");

    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd");
    String date = formatter.format(dt);
    System.out.println(date);
}