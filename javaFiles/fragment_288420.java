Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));            
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));       

c1.setTime(sdf.parse("20:00"));
System.out.println(c1.getTimeInMillis());