long ms = yourDate.getTime();
Calendar c = Calendar.getInstance();
c.setTimeInMillis(ms);
c.add(Calendar.DATE, 1);
long nextDayInMillis = c.getTimeInMillis();
Date nextDate=new Date(nextDayInMillis);