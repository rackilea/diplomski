Calendar c = Calendar.getInstance();
Integer year1 = c.get(c.YEAR);
Integer week1 = c.get(c.WEEK_OF_YEAR);

Calendar c = Calendar.getInstance();
c.setTimeInMillis(/*Second date in millis here*/);
Integer year2 = c.get(c.YEAR);
Integer week2 = c.get(c.WEEK_OF_YEAR);

if(year1 == year2) {
    if(week1 == week2) {
         //Do what you want here
    }
}