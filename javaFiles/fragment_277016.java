public Date adjustDateTimeZoneToUTC( Date date )
{
    Date utcDate = null;
    if( date != null )
    {
        int curOffset = TimeZone.getDefault().getRawOffset();

        DateTime dt = new DateTime(date).withZoneRetainFields(DateTimeZone.UTC);
        // Se o offset for NEGATIVO(-12:00), deve-se somar esse tempo
        // Se o offset for POSITIVO(+12:00), deve-se subtrair esse tempo
        if( curOffset >= 0 ) {
            dt.minusMillis(curOffset);
        } else {
            curOffset *= -1;
            dt.plusMillis(curOffset);
        }
        utcDate = dt.toDate();
    }
    return utcDate;
}