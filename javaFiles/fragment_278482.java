String input = "2017-Oct-27";
SimpleDateFormat parser = new SimpleDateFormat("yyyy-MMM-dd");
String formattedDate= "";
Date date;
try {
    date = parser.parse(input);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    formattedDate = formatter.format(date);
} catch (ParseException e1) {
    e1.printStackTrace();
}