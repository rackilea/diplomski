public class Test {

    static final String sample_date = "Sat May 02 2015 00:00:00 GMT+0500 (Pakistan Standard Time)".replace("GMT", "")
            .replace(" (Pakistan Standard Time)", "");

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss Z");
        ParsePosition position = new ParsePosition(0);
        Date d = sdf.parse(sample_date, position);
        System.out.println(d);
        System.out.println(position);
        if (position.getErrorIndex() != -1) {
            System.out.println(sample_date.substring(position.getErrorIndex()));
        }
        System.out.println(sdf.parse(sample_date));
    }
}