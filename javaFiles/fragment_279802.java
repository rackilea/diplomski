private static final DateFormat DEFAULT_DATE_FORMAT;

static {
    DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    DEFAULT_DATE_FORMAT.setLenient(false);
}



public Calendar getCalendar(String dateAsString) {
    Calendar value = Calendar.getInstance();
    Date d = DEFAULT_DATE_FORMAT.parse(dateAsString);
    value.setTime(d);
    return value;
}