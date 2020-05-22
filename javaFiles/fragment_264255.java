Calendar cal = Calendar.getInstance();

int weekday = cal.get(Calendar.DAY_OF_WEEK);
int days = (Calendar.SATURDAY - weekday + 2) % 7;

cal.add(Calendar.DAY_OF_YEAR, days);

cal.add(Calendar.DAY_OF_MONTH, -7);
cal.add(Calendar.DAY_OF_MONTH, -7);