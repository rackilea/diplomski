String str = obj.getString("eventdate").replaceAll("\\D+", "");
String upToNCharacters = str.substring(0, Math.min(str.length(), 13));
DateFormat timeZoneFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
timeZoneFormat.setTimeZone(TimeZone.getTimeZone("GMT-8"));

Date time = new java.util.Date(Long.parseLong(upToNCharacters));
//                                System.out.println(time);
model.setDate(String.valueOf(timeZoneFormat.format(time)));