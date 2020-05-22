String dateString = "10/26/2011";
String dateStringParsed = "";
SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
SimpleDateFormat format2 = new SimpleDateFormat("EEE, dd MMM yyyy");

try {
    Date parsed = format1.parse(dateString);
    dateStringParsed = format2.format(parsed);
}
catch(ParseException pe) { 
    //handle the exception
}