private Calendar lastSelectedCalendar = null;
private CalendarView calendarView;


calendarView = (CalendarView) findViewById(R.id.calendarView);
lastSelectedCalendar = Calendar.getInstance();
calendarView.setMinDate(lastSelectedCalendar.getTimeInMillis() - 1000);
calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

@Override
public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
    Calendar checkCalendar = Calendar.getInstance();
    checkCalendar.set(year, month, dayOfMonth);
    if(checkCalendar.equals(lastSelectedCalendar))
        return;
    if(checkCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
        calendarView.setDate(lastSelectedCalendar.getTimeInMillis());
    else
        lastSelectedCalendar = checkCalendar;
}
});