Calendar c = Calendar.getInstance();
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
long millis = (System.currentTimeMillis() - c.getTimeInMillis());