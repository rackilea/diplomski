DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendFixedDecimal(DateTimeFieldType.year(),4)
    .appendFixedDecimal(DateTimeFieldType.monthOfYear(),2)
    .appendFixedDecimal(DateTimeFieldType.dayOfMonth(),2)
    .toFormatter()
    .withZoneUTC();