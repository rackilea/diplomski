expDate.setTime(exp);
todayDate.setTime(today);
expDate.setTimeZone(tzone);
todayDate.setTimeZone(tzone);

expDate.set(Calendar.HOUR_OF_DAY, 0);
expDate.set(Calendar.MINUTE, 0);
expDate.set(Calendar.SECOND, 0);
expDate.set(Calendar.MILLISECOND, 0);

todayDate.set(Calendar.HOUR_OF_DAY, 0);
todayDate.set(Calendar.MINUTE, 0);
todayDate.set(Calendar.SECOND, 0);
todayDate.set(Calendar.MILLISECOND, 0);

double diff = ((double)expDate.getTimeInMillis()-(double)todayDate.getTimeInMillis())/86400000;

return Math.round(diff);