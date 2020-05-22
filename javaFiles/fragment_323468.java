String string = "2016-03-15";
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
try {
    Date date = dateFormat.parse(string);
    System.out.println(date);
} catch (ParseException ex) {
    System.out.println(ex);
}