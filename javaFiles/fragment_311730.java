// Set the time in String
String stringDate = "04:10:13";
// Parse this time 
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
Calendar cal = Calendar.getInstance();
// Set the parsed time to a Calendar object
cal.setTime(sdf.parse(stringDate));