Calendar curTime = new GregorianCalendar();
curTime.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
DateFormat dateFormat = new SimpleDateFormat("HH:mm");
dateFormat.setCalendar(curTime);

String time = dateFormat.format(curTime.getTime());
System.out.println(time);