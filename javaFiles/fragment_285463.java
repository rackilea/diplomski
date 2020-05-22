java.util.Calendar cal = Calendar.getInstance();
cal.setTimeZone(TimeZone.getTimeZone("UTC"));
java.sql.Timestamp ts = resultSet.getTimestamp(PUBLISH_TIME);
cal.setTime(ts);

SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
System.out.println(sdf.format(cal.getTime()));