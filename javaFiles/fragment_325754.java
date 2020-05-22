DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
Date date = sdf.parse(initialTime);
Calendar cal = Calendar.getInstance();
cal.setTime(date);

cal.add(Calendar.HOUR_OF_DAY, hours);
cal.add(Calendar.MINUTE, minutes);

date = cal.getTime();