public class Utils {

    public static void main(String[] args) {

        String mytime="Jan 17, 2012";
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MMM dd, yyyy");

        Date myDate = null;
        try {
            myDate = dateFormat.parse(mytime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        String finalDate = timeFormat.format(myDate);

        System.out.println(finalDate);
    }
}