String inputstring="Tue Nov 5 00:00:00 UTC+0530 2013";
SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zZ yyyy", Locale.ENGLISH);
DateFormat outformat = new SimpleDateFormat("dd-MMM-yy");
try {
    String result = outformat.format(formatter.parse(inputstring));
    System.out.println(result);
} catch (ParseException ex) {
    ex.printStackTrace();
}