String dateString = "2012-04-26T08:38:00";
SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
Date date = null;
try {
    date = parser.parse(dateString);
} catch (ParseException e) {
    // error parsing.
}
if (date != null) {
    // do something with date.
}