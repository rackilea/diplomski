java.sql.Timestamp ts =                           // Avoid using this badly-designed legacy class if at all possible.
    Timestamp                                     // You can convert back-and-forth between legacy and modern classes.
    .from(                                        // New method added to legacy class to convert from modern class.
        OffsetDateTime                            // Represents a moment with an offset-of-UTC, a number of some hours-minutes-seconds ahead or behind UTC.
       .parse( "2019-01-22T13:09:54.620-05:00" )  // Text in standard ISO 8601 format can be parsed by default, without a formatting pattern.
       .toInstant()                               // Adjust from an offset to UTC (an offset of zero) by extracting an `Instant`. 
    )                                             // Returns a `Timestamp` object. Same moment as both the `OffsetDateTime` and `Instant` objects.
;