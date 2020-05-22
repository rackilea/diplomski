public class DateKey {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String dateKey;

    public DateKey(Date date) {
        dateKey = dateFormat.format(date);
    }

    public String getDateKey() {
        return dateKey;
    }

}