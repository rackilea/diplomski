// ISO 8601 format without (!) timezone
DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"); 
Date myDate = new Date(...); // to avoid time zone problems here, prefer
                             // storing calendar dates on the server as
                             // Strings, too (or use Joda Time Partials)
String dateForClient = DATE_FORMAT.format(myDate);