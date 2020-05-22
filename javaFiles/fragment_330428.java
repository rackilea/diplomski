public static Timestamp convertStringToTimestampWithTimeZone(String fromTimeZone, String toTimeZone, String input){
        String pattern = "yourdatetimeformat";
        DateTime dt  = DateTime.parse(input, DateTimeFormat.forPattern(pattern)).withZoneRetainFields(DateTimeZone
            .forID(fromTimeZone)).withZone(DateTimeZone.forID(toTimeZone));
        Timestamp ts = new Timestamp(dt.getMillis());
        return ts;}