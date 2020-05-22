Calendar cal = Calendar.getInstance();

SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
Date date = sdf.parse("8:00");
cal.setTime(date);

int mins = cal.get(Calendar.HOUR)*60 + cal.get(Calendar.MINUTE);