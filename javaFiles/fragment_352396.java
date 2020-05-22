String OLD_FORMAT = "yyyy-MM-dd";
String NEW_FORMAT = "dd-MMM-yyyy";

String oldDateString = "2015-04-08";
String newDateString;

SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
Date d = sdf.parse(oldDateString);
sdf.applyPattern(NEW_FORMAT);
newDateString = sdf.format(d);