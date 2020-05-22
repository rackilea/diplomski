SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
// Set UTC to my original date format as it is my input TimeZone
mFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = mFormat.parse("2016-06-11T11:14:57.000Z");
SimpleDateFormat endFormat = new SimpleDateFormat("hh:mm a");
// Set GMT + 5 to my target date format as it is my output TimeZone
endFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:00"));

System.out.println(endFormat.format(date));