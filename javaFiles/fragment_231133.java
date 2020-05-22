Calendar dCal = Calendar.getInstance();
  dCal.setTime(date);
  Calendar tCal = Calendar.getInstance();
  tCal.setTime(time);
  dCal.set(Calendar.HOUR_OF_DAY, tCal.get(Calendar.HOUR_OF_DAY));
  dCal.set(Calendar.MINUTE, tCal.get(Calendar.MINUTE));
  dCal.set(Calendar.SECOND, tCal.get(Calendar.SECOND));
  dCal.set(Calendar.MILLISECOND, tCal.get(Calendar.MILLISECOND));
  date = dCal.getTime();