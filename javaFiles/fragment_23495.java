Calendar c = Calendar.getInstance();

// set the calendar to start of today
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);

// and get that as a Date
Date today = c.getTime();

// or as a timestamp in milliseconds
long todayInMillis = c.getTimeInMillis();

// user-specified date which you are testing
// let's say the components come from a form or something
int year = 2011;
int month = 5;
int dayOfMonth = 20;

// reuse the calendar to set user specified date
c.set(Calendar.YEAR, year);
c.set(Calendar.MONTH, month);
c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

// and get that as a Date
Date dateSpecified = c.getTime();

// test your condition
if (dateSpecified.before(today)) {
  System.err.println("Date specified [" + dateSpecified + "] is before today [" + today + "]");
} else {
  System.err.println("Date specified [" + dateSpecified + "] is NOT before today [" + today + "]");
}