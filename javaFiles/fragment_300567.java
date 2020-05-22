String time = "2:00 pm";
 SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
 Date date = df.parse(time); 
 Calendar cal = Calendar.getInstance();
 cal.setTime(date);
 cal.add(Calendar.HOUR, 3);
 cal.add(Calendar.MINUTE, 30);
 int h = cal.get(Calendar.HOUR_OF_DAY);
 int m = cal.get(Calendar.MINUTE);