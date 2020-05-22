Calendar cal = Calendar.getInstance();  

    long l = cal.getTimeInMillis();

    long cal_Id = 1;

    **// Also Here Use Cal_Id = 1 not parse another value** 

    ContentResolver CR = getContentResolver();


     ContentValues calEvent  = new ContentValues();

     calEvent.put(CalendarContract.Events.CALENDAR_ID,  cal_Id); // XXX pick)

     calEvent.put(CalendarContract.Events.TITLE, " Demo Data");

     calEvent.put(CalendarContract.Events.DTSTART,l);

     calEvent.put(CalendarContract.Events.DTEND, l+60 * 1000);

     calEvent.put(CalendarContract.Events.EVENT_TIMEZONE, "Indian/Christmas");