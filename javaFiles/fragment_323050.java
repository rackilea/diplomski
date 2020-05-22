String dateStr = "2013-05-16 14:52:00.943"; 

SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S"); // your web service format
Date pDate = c.parse(dateStr); 
SimpleDateFormat p = new SimpleDateFormat("dd-MM-yyyy"); // your required format

String formatDate = p.format(pDate); // convert it in your required format
SimpleDateFormat formatter = new SimpleDateFormat("EEEE"); // Day format as you want EEE for like "Sat" and EEEE for like "Saturday"
String Day = formatter.format(pDate); // This will give you a day as your selected format

System.out.println("Date & Day>>>"+formatDate+" "+Day);