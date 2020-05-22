SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm");
Calendar now = Calendar.getInstance(); 
System.out.println(formatter.format(now.getTime()));
TimeZone gmt = TimeZone.getTimeZone("GMT");
formatter.setTimeZone(gmt);
System.out.println(formatter.format(now.getTime()));