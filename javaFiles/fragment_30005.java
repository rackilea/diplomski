Calendar calendar = Calendar.getInstance();
date.set(Calendar.DAY_OF_WEEK, getUserInputDay()); //
calendar.set(Calendar.HOUR_OF_DAY, getUserInputHour());
calendar.set(Calendar.MINUTE, getUserInputMinute());
calendar.set(Calendar.SECOND, getUserInputSeconds());
Date time = calendar.getTime();

timer = new Timer();
timer.schedule(new ReportGenerator(), time);