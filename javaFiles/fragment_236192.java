SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
Date date = formatter.parse("2/19/2019 4:15 PM");

DateTime startDateTimeNY = new DateTime(date,TimeZone.getTimeZone("America/New_York")); 
DateTime startDateTimeSG = new DateTime(date,TimeZone.getTimeZone("Asia/Singapore"));   
DateTime startDateTimeNBO = new DateTime(date,TimeZone.getTimeZone("Africa/Nairobi"));  
System.out.println(startDateTimeNY); //prints 2019-02-19T16:15:00.000-05:00
System.out.println(startDateTimeSG); //prints 2019-02-20T05:15:00.000+08:00
System.out.println(startDateTimeNBO); //prints 2019-02-20T00:15:00.000+03:00