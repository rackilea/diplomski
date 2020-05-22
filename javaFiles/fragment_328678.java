String string_date = "12-December-2012";

SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
try {
    Date d = f.parse(string_date);
    long milliseconds = d.getTime();
} catch (ParseException e) {
    e.printStackTrace();
}