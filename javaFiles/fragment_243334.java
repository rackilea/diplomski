// h instead of H  because of AM/PM-format
DateFormat parseFormat = new SimpleDateFormat("M/dd/yyyy hh:mm:ss aaa XXX"); 
Date dt = null;
try {
  dt = parseFormat.parse("3/15/2013 3:01:53 PM -06:00");
}catch (ParseException e) {
  e.printStackTrace();
} 

DateFormat printFormat = new SimpleDateFormat("M/dd/yyyy hh:mm:ss aaa XXX"); 
printFormat.setTimeZone(TimeZone.getTimeZone("GMT-05")); 
String newDateString = printFormat.format(dt);
System.out.println(newDateString);