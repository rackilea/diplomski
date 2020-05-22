Calendar cal = Calendar.getInstance();
TimePicker tp;

// ...

cal.set(Calendar.HOUR_OF_DAY, tp.getCurrentHour());
cal.set(Calendar.MINUTE, tp.getCurrentMinute());
long minutes = (cal.getTimeInMillis() -
    Calendar.getInstance().getTimeInMillis()) / 1000 / 60;