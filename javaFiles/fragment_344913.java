private Date dateFromHourMinSec(final String hhmmss)
{
    if (hhmmss.matches("^[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$"))
    {
        final String[] hms = hhmmss.split(":");
        final GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hms[0]));
        gc.set(Calendar.MINUTE, Integer.parseInt(hms[1]));
        gc.set(Calendar.SECOND, Integer.parseInt(hms[2]));
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }
    else
    {
        throw new IllegalArgumentException(hhmmss + " is not a valid time, expecting HH:MM:SS format");
    }
}