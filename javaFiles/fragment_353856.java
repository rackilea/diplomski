Calendar end = new GregorianCalendar(2013, 05, 05, 12, 40, 0);
Calendar start = new GregorianCalendar(2013, 05, 05, 12, 15, 0);

Calendar diff = end - start;
int minutes = diff.get(Calendar.Minutes);
int seconds = diff.get(Calendar.Seconds);