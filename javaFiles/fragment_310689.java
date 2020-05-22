// Joda-Time cannot parse "EDT" so we use hard-coded offsets
public static final DateTimeZone EST = DateTimeZone.forOffsetHours(-5);
public static final DateTimeZone EDT = DateTimeZone.forOffsetHours(-4);

public static final DateTimeZone EASTERN = DateTimeZone.forID("America/New_York");
public static final org.joda.time.format.DateTimeFormatter FORMATTER = 
    org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");