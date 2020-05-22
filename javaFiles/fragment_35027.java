final DateTimeFormatter formatter = new DateTimeFormatterBuilder() 
.appendValue(HOUR_OF_DAY, 2) 
.appendLiteral(':') 
.appendValue(MINUTE_OF_HOUR, 2) 
.appendLiteral(':') 
.appendValue(SECOND_OF_MINUTE, 2) 
.optionalStart() 
.appendFraction(MILLI_OF_SECOND, 0, 3, true) 
.toFormatter();