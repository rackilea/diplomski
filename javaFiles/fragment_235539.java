public static final DateTimeFormatter ISO_LOCAL_DATE; 
   static { 
     ISO_LOCAL_DATE = new DateTimeFormatterBuilder() 
       .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD) 
       .appendLiteral('-') 
       .appendValue(MONTH_OF_YEAR, 2) 
       .appendLiteral('-') 
       .appendValue(DAY_OF_MONTH, 2) 
       .toFormatter(ResolverStyle.STRICT).withChronology(IsoChronology.INSTANCE); 
     }