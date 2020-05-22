Date userDate = ...;
TimeZone userTimeZone = ...;

int companyWorkStartHour = 13;
int companyWorkEndHour = 18;

Calendar cal = Calendar.getInstance();
cal.setTime(userDate);
cal.setTimeZone(userTimeZone);

int hour = cal.get(Calendar.HOUR_OF_DAY);
boolean withinCompanyHours = (hour >= companyWorkStartHour && hour < companyWorkEndHour);