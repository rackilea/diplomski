public class TestParse {
    public static void main(String[] args) {
        String myDate = "17-Mar-2006";
        Date date = getDateFromString(myDate);
        // Set the Calendar
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // format date
        String formattedDate = getStringFromDate(calendar);
        System.out.printf("The formatted date is : %s & the dates are equal %s%n", formattedDate, formattedDate.equals(myDate));
    }

    public static String getStringFromDate(GregorianCalendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        simpleDateFormat.setCalendar(calendar);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Date getDateFromString(String input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        Date date = null;
        try {
            date = simpleDateFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}