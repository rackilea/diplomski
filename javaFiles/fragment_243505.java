final Date endDate;
final Date startDate;


Long diff = endDate.getTime() - startDate.getTime(); // calculate the difference
Date dateDiff = new Date(diff);                      // convert it to a date
Calendar c = Calendar.getInstance();                 // get a calendar instance
c.setTime(dateDiff);                                 // set it to the calendar
int yearDiff = c.get(Calendar.YEAR)-1970;            // read the year and substract the "0-year" value which is 1970