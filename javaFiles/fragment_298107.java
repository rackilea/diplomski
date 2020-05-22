public class TestParse {
    public static void main(String[] args) {
        String myDate = "17-Mar-2006";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar calendar =  new GregorianCalendar();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }
}