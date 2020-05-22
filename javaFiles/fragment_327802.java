Duration                              // Represent a span-of-time as 24-hour days, hours, minutes, seconds, and nanoseconds.
.between(                             // Calculate elapsed time.
    javaUtilDateStart.toInstant() ,   // Convert any `java.util.Date` to `java.time.Instant`. Never use `Date`; it is a terrible class, ditto for `Calendar`. 
    javaUtilDateStop.toInstant()
)                                      // Returns a `Duration` object.
.toString()                            // Generate text in standard ISO 8601 format.