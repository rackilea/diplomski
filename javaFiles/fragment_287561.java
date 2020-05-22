// shared with everyone else calling the same SimpleDateFormat
protected Calendar calendar;
...
// method from DateFormat that is extended by SimpleDateFormat
private StringBuffer format(Date date, StringBuffer toAppendTo, FieldDelegate delegate) {
    calendar.setTime(date);
    ...