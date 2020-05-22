String[] allTimeZones = TimeZone.getAvailableIDs();
Date now = new Date();
for (int i = 0; i < allTimeZones.length; i++) {
    TimeZone tz = TimeZone.getTimeZone(allTimeZones[i]);
    System.out.format("%s;%s; %f \n", allTimeZones[i], 
            tz.getDisplayName(tz.inDaylightTime(now), TimeZone.LONG), 
            (float) (tz.getOffset(now.getTime())/3600000.0));
}