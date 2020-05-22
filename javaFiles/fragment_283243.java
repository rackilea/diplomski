Calendar lastDate = Calendar.getInstance();
lastDate.setTime(toDate);
lastDate.add(Calendar.DATE, -1);

Calendar cal = Calendar.getInstance();
cal.setTime(fromDate);
while (cal.before(lastDate)) {...}