static final DateFormat CRAZY_FORMAT = new SimpleDateFormat("");

public String getData(@QueryParam("date") String dateString) {
    final Date date;
    try {
        date = new Date(dateString); // yes, I know this is a deprecated method
    } catch(Exception e) {
        date = CRAZY_FORMAT.parse(dateString);
    }
}