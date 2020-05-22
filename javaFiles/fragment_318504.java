SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
parser.setTimeZone(TimeZone.getTimeZone("UTC"));
Date parsed = parser.parse(utcDate);

SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy hh:mm a");
System.out.println(formatter.format(parsed));