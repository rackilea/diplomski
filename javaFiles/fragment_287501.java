Date localTime = new Date(); 

 //creating DateFormat for converting time from local timezone to GMT
 DateFormat converter = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");

 //getting GMT timezone, you can get any timezone e.g. UTC
 converter.setTimeZone(TimeZone.getTimeZone("GMT"));

 System.out.println("local time : " + localTime);;
 System.out.println("time in GMT : " + converter.format(localTime));