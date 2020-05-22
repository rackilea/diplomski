SimpleDateFormat dateReader = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
try {
  dateReader.parse("Thu, 03 Aug 2017 20:10:00 +0200");
} catch (ParseException e) {
  e.printStackTrace();
}