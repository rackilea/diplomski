String dateTime = "11/15/2013 08:00:00";
// Format for input
SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
// Parsing the date
Date date7 = dateParser.parse(dateTime);
// Format for output
SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
// Printing the date
System.out.println(dateFormatter.format(date7));