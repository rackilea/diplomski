//Parse String for Date
SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
Date myDate = format.parse(stringDate);

//Use Calendar to add 3 hours
Calendar c = Calendar.getInstance();
c.setTime(myDate);
c.add(Calendar.HOUR_OF_DAY, 3);

//Retransform date to String
String newDate= format.format(c.getTime());