// The String pattern defines how date strings are parsed and formated
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

String dateString = "09/10/2014";

// Convert a String to Date
Date dateFromDateString = sdf.parse(dateString);

// Convert a Date to a String
String dateStringFromDate = sdf.format(dateFromDateString);