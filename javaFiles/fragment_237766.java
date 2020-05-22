String[] projection = new String[] {
        CalendarContract.Reminders._ID,
        CalendarContract.Reminders.METHOD,
        CalendarContract.Reminders.MINUTES
};

Cursor cursor = CalendarContract.Reminders.query(
    contentResolver, eventId, projection);
while (cursor.moveToNext()) {
    long reminderId = cursor.getLong(0);
    int method = cursor.getInt(1);
    int minutes = cursor.getInt(2);

    // etc.

}
cursor.close();