SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
int minutesToAdd = 720;
Calendar cal = Calendar.getInstance();

cal.setTime(dateFormat.parse("2009/06/21 00:00:00"));  // Next sunday
cal.add(Calendar.MINUTE, minutesToAdd);

Date result = cal.getTime();                           // Voila