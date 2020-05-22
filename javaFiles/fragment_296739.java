String input = "2012/01/20 12:05:10.321";
DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
Date date = inputFormatter.parse(input);

DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
String output = outputFormatter.format(date); // Output : 01/20/2012