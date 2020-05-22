Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(milliseconds);
return cal.get(Calendar.HOUR_OF_DAY) == 0
       && cal.get(Calendar.MINUTE) == 0
       && cal.get(Calendar.SECOND) == 0
       && cal.get(Calendar.MILLISECOND) == 0;