...
String [] ids = TimeZone.getAvailableIDs();
for(String id:ids) {
  TimeZone zone = TimeZone.getTimeZone(id);
  int offset = zone.getRawOffset()/1000;
  int hour = offset/3600;
  int minutes = (offset % 3600)/60;
  System.err.println(String.format("(GMT%+d:%02d) %s", hour, minutes, id));
}   
...