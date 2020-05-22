public static Component getCalendarEvent(String myCalendarString) 
{
    try {
        StringReader sin = new StringReader(myCalendarString);
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(sin);

        return (Component)calendar.getComponent("VEVENT");

    } catch (Exception e) {e.printStackTrace();}

    return null;
}