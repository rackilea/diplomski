Calendar cal = Calendar.getInstance();
cal.set(Calendar.SECOND, 59);
cal.set(Calendar.HOUR, 23);
cal.set(Calendar.MINUTE, 59);

long diff = cal.getTime().getTime() - today.getTime();