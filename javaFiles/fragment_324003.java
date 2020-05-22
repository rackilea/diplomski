@Override
public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, 0);

    if (hasSelected == 1) {
        startTwiceDailyNotification(calendar);
    } 
    else if (hasSelected == 2) {
        startTwiceDailyNotification2(calendar);
    }
}