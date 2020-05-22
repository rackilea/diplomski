private Date convertDate(String date) {
Calendar calendar = Calendar.getInstance();
String year = String.valueOf(calendar.get(Calendar.YEAR));
String str = String.format("%s %s %s", getDay(date), getMonth(date), year);
DateFormat format = new SimpleDateFormat("d MMMM yyyy");
try {
    return format.parse(str);
} catch (ParseException e) {
    e.printStackTrace();
}
return null;