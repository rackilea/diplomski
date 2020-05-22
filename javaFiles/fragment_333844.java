Calendar calendar = Calendar.getInstance();
    Date currenthour= calendar.getTime();

    Calendar calendarTmp = Calendar.getInstance();
    calendarTmp.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
    calendarTmp.set(Calendar.MINUTE, timePicker.getCurrentMinute());
    calendarTmp.set(Calendar.SECOND, 0);

    if (currenthour.after(calendarTmp.getTime()) && currenthour.before(calendarTmp.getTime())){

        //DO SOMETHING
    }