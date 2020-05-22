Calendar c = Calendar.getInstance();
c.setTimeInMillis(((long) unixTimeStamp) * 1000L);
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int day = c.get(Calendar.DAY_OF_MONTH);
datePickerDateDue.init(year, month, day, null);