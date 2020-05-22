SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
format.setTimeZone(TimeZone.getTimeZone("UTC"));

String dateString = "2013-12-27T11:15:10.382Z";

try {
    Date date  = format.parse(dateString);
    System.out.println(date);
}
catch (Exception e) {
    e.printStackTrace();
}