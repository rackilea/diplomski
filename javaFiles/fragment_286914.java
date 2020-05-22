String timezoneOffset = " UTC";
dateFormatterLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");  
dateFormatterLocal.setTimeZone(TimeZone.getTimeZone("America/New York"));
for (int i = 0; i < list.length; i++) {
   timeStampArrayList.add(dateFormatterLocal.parse(list[i] + timezoneOffset ));
}