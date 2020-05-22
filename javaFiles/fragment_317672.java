/** 1 = Sunday, 2 = Monday, 3 = Tuesday, 4 = Wednesday, 5 = Thursday,
* 6 = Friday, 7 = Saturday
*/
public static Date getFirstDayOfWeekDate(int firstDay)
{
    // Calculate the date of the first day of the week

    // First get the today's date
    Calendar c = new GregorianCalendar();

    // Now set the day of week to the first day of week
    while (c.get(Calendar.DAY_OF_WEEK) != firstDay)
    {
        c.add(Calendar.DAY_OF_MONTH, -1);
    }

    return c.getTime();
}