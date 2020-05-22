java.sql.Timestamp timeStampDate = null;
String dateString = "2018-10-17T22:37:10.000+0000";

try {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    Date date = formatter.parse(dateString);
    timeStampDate = new Timestamp(date.getTime());

} catch (ParseException e) {
    e.printStackTrace();
}