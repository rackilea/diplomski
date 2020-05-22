Calendar calendar = getCalendar(new Date());
calendar.add(Calendar.MONTH, -1);
calendar.set(Calendar.DAY_OF_MONTH, 1);
calendar = getTimeToBeginningOfDay(calendar);

return calendar.getTime();