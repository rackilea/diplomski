Calendar c=Calendar.getInstance();
c.getTimeInMillis();
String cur_day=String.format("%te %B %tY",c,c,c); // This will give date like 22 February 2012

c.setTimeInMillis(time);//set your saved timestamp
String that_day=String.format("%te %B %tY",c,c,c); //this will convert timestamp into format like 22 February 2012

//you can compare days,months,year,hours,minutes,seconds and milliseconds using above method.you can find various formats in below link