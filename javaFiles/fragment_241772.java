long millis = new Date().getTime();
String uk = SimpleDateFormat
               .getTimeInstance(SimpleDateFormat.MEDIUM, Locale.UK)
               .format(millis);
String us = SimpleDateFormat
               .getTimeInstance(SimpleDateFormat.MEDIUM, Locale.US)
               .format(millis);
System.out.println("UK: " + uk);
System.out.println("US: " + us);