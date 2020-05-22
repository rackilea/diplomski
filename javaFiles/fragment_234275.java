Calendar cal = Calendar.getInstance();
long now = cal.getTime().getTime();

cal.set(Calendar.HOUR_OF_DAY,   23);
cal.set(Calendar.MINUTE,        30);
cal.set(Calendar.SECOND,        0);
cal.set(Calendar.MILLISECOND,   0);

long endMillis = cal.getTime().getTime();
long timeToSleep = endMillis - now;