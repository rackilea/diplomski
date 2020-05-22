String inputDateString = "15-1-2012";
DateFormat dfFrom = new SimpleDateFormat("dd-MM-yyyy");
Date inputDate = dfFrom.parse(inputDateString);

DateFormat dfTo = new SimpleDateFormat("d MMMM yyyy");
String outputDate = dfTo.format(inputDate);