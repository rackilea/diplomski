import java.util.Calendar;

Calendar c = Calendar.getInstance(); 
//Set time in milliseconds
c.setTimeInMillis(milliseconds);
int mYear = c.get(Calendar.YEAR);
int mMonth = c.get(Calendar.MONTH); 
int mDay = c.get(Calendar.DAY_OF_MONTH);
int hr = c.get(Calendar.HOUR);
int min = c.get(Calendar.MINUTE);
int sec = c.get(Calendar.SECOND);