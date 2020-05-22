public void setTimeZone(TimeZone value)
{
    zone = value;
    sharedZone = false;
    /* Recompute the fields from the time using the new zone.  This also
     * works if isTimeSet is false (after a call to set()).  In that case
     * the time will be computed from the fields using the new zone, then
     * the fields will get recomputed from that.  Consider the sequence of
     * calls: cal.setTimeZone(EST); cal.set(HOUR, 1); cal.setTimeZone(PST).
     * Is cal set to 1 o'clock EST or 1 o'clock PST?  Answer: PST.  More
     * generally, a call to setTimeZone() affects calls to set() BEFORE AND
     * AFTER it up to the next call to complete().
     */
    areAllFieldsSet = areFieldsSet = false;
}