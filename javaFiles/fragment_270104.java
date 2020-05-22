JXDatePicker picker = new JXDatePicker();
Calendar calendar = picker.getMonthView().getCalendar();
// starting today if we are in a hurry
calendar.setTime(new Date());
picker.getMonthView().setLowerBound(calendar.getTime());
// end of next week
CalendarUtils.endOfWeek(calendar);
calendar.add(Calendar.WEEK_OF_YEAR);
picker.getMonthView().setUpperBound(calendar.getTime());