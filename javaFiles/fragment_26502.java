Date date = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH);
int day = calendar.get(Calendar.DAY_OF_MONTH);

//creating a new calendar with all of the data
Calendar cal = Calendar.getInstance();
cal.set(year, month, day, hours, mins, seconds);