public static String getCalendarUriBase(Activity act) {     
    String calendarUriBase = null;
    Uri calendars = Uri.parse("content://calendar/calendars");
    Cursor managedCursor = null;

    try {
        managedCursor = act.getContentResolver().query(calendars,
                null, null, null, null);
    } catch (Exception e) {
    }

    if (managedCursor != null) {
        calendarUriBase = "content://calendar/";
    } else {
        calendars = Uri.parse("content://com.android.calendar/calendars");
        try {
            managedCursor = act.getContentResolver().query(calendars,
                    null, null, null, null);
        } catch (Exception e) {
        }
        if (managedCursor != null) {
            calendarUriBase = "content://com.android.calendar/";
        }
    }

    calendar_uri= calendarUriBase;
    return calendarUriBase;
}