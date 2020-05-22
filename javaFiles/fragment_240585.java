SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

//Convert timestamp to date 
Date d = sdf.parse(myStringTimeStamp, new ParsePosition(0)); 

sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

newTimeStamp = sdf.format(d);