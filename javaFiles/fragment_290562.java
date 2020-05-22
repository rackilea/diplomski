final Calendar c = Calendar.getInstance();
hour = c.get(Calendar.HOUR_OF_DAY);
minute = c.get(Calendar.MINUTE);

timePicker1 = (TimePicker) findViewById(R.id.timePicker1); //supposed you have defined the "timePicker1" id in your layout xml
timePicker1.setCurrentHour(hour);
timePicker1.setCurrentMinute(minute);