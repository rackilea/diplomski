private transient long fastTime;

/*
 * If cdate is null, then fastTime indicates the time in millis.
 * If cdate.isNormalized() is true, then fastTime and cdate are in
 * synch. Otherwise, fastTime is ignored, and cdate indicates the
 * time.
 */
private transient BaseCalendar.Date cdate;