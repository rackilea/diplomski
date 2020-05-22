String pattern = "dd-MMM-yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
Date date = simpelDateFormat.parse(yourdateString);
Calendar now = Calendar.getInstance();
now.setTime(date);
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
int day = now.get(Calendar.DAY_OF_MONTH);