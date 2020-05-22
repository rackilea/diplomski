//First date
Date d1 = dateFormat.parse("31-10-13");

//Second date
Date d2 = dateFormat.parse("31-08-13");

//Interval:     
long intervalMs = d1.getTime() - d2.getTime();
long intervalDays = intervalMs/(1000*60*60*24);