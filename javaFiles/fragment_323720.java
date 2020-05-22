// make it now
Calendar dateCal = Calendar.getInstance();
// make it tomorrow
dateCal.add(Calendar.DAY_OF_YEAR, 1);
// Now set it to the time you want
dateCal.set(Calendar.HOUR_OF_DAY, hours);
dateCal.set(Calendar.MINUTE, minutes);
dateCal.set(Calendar.SECOND, seconds);
dateCal.set(Calendar.MILLISECOND, 0);
return dateCal.getTime();