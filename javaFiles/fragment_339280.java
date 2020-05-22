public void addEvent(long calendarID, String title, long startEvent,
            long endEvent, int reminder, String description, long createDate) {
        try {
            System.out.println("add event to calendar");
            ContentResolver cr = context.getContentResolver();
            ContentValues values = new ContentValues();
            values.put(Events.DTSTART, startEvent);
            values.put(Events.DTEND, endEvent);
            values.put(Events.TITLE, title);
            values.put(Events.DESCRIPTION, description);
            values.put(Events.CALENDAR_ID, calendarID);
            values.put(Events.EVENT_TIMEZONE, Calendar.getInstance()
                    .getTimeZone().getID());
            System.out.println(Calendar.getInstance().getTimeZone().getID());
            Uri uri = cr.insert(Events.CONTENT_URI, values);
            long eventId = Long.parseLong(uri.getLastPathSegment());
            setReminder(cr, eventId, reminder);             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setReminder(ContentResolver cr, long eventID, int reminder) {
        try {
            ContentValues values = new ContentValues();
            values.put(Reminders.MINUTES, reminder / 60000);
            values.put(Reminders.EVENT_ID, eventID);
            values.put(Reminders.METHOD, Reminders.METHOD_ALERT);
            Uri uri = cr.insert(Reminders.CONTENT_URI, values);
            Cursor c = Reminders.query(cr, eventID,
                    new String[] { Reminders.MINUTES });
            if (c.moveToFirst()) {
                System.out.println("calendar"
                        + c.getInt(c.getColumnIndex(Reminders.MINUTES)));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }