Calendar dateCal = Calendar.getInstance();
dateCal.setTime(date);

Calendar currentCal = Calendar.getInstance();
currentCal.setTimeInMillis(System.currentTimeMillis()); 

dateCal.set(Calendar.HOUR, currentCal.get(Calendar.HOUR));
dateCal.set(Calendar.MINUTE, currentCal.get(Calendar.MINUTE));