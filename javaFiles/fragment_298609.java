JXDatePicker picker = new JXDatePicker();
Calendar calendar = picker.getMonthView().getCalendar();

// set any date to it (for e.g. today)
calendar.setTime(new Date());
picker.getMonthView().setLowerBound(calendar.getTime());

// set it to end when you want
CalendarUtils.endOfWeek(calendar);
calendar.add(Calendar.WEEK_OF_YEAR);
picker.getMonthView().setUpperBound(calendar.getTime());