String value = "Sunday, September 29, 2013 7:59:58 AM PDT";
String format = "EEEE, MMMM dd, yyyy h:mm:ss a zzz";
SimpleDateFormat sdf = new SimpleDateFormat(format);
try {
    Date date = sdf.parse(value);
    System.out.println(date);
    System.out.println(sdf.format(date));
} catch (ParseException ex) {
    ex.printStackTrace();
}