public class DateParameter implements Serializable {
    public static DateParameter valueOf(String dateString) {
        try {
            date = new Date(dateString); // yes, I know this is a deprecated method
        } catch(Exception e) {
            date = CRAZY_FORMAT.parse(dateString);
        }
    }

    private Date date;
    // Constructor, Getters, Setters
}

public String getData(@QueryParam("date") DateParameter dateParam) {
    final Date date = dateParam.getDate();
}