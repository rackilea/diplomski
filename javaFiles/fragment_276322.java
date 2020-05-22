java.util.Date d1, d2;

DateTime dt1 = new DateTime(d1);
DateTime dt2 = new DateTime(d2);

int numDays = Days.daysBetween(dt1, dt2).getDays(); 
int hours = Hours.hoursBetween(dt1, dt2).getHours() % 24;
int minutes = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60);
int seconds = Seconds.secondsBetween(dt1, dt2).getSeconds() % 60);

if (numDays > 0) { return "A few days ago"; }
else if (hours > 0) { return "A few hours ago"; }
// And so on