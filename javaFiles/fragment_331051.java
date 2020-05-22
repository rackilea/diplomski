long now = System.currentTimeMillis();
for( String tzID: "EST,EDT,America/New_York".split(",")) {
    TimeZone tz = TimeZone.getTimeZone( tzID);
    System.out.println( tz.getDisplayName() + " now=" + tz.getOffset( now) / 36e5 
                     + " / +182=" + tz.getOffset( now + 182 * 86400000L) / 36e5);
}