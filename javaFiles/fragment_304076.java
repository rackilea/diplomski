package com.example;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaTimeHelper {

    static final public DateTime START_OF_TIME = new DateTime( 0000, 1, 1, 0, 0, 0, DateTimeZone.UTC );
    static final public DateTime END_OF_TIME = new DateTime( 9999, 1, 1, 0, 0, 0, DateTimeZone.UTC );

    static final public DateTime MINIMUM_INVOICE_DATETIME = new DateTime( 2015, 1, 1, 0, 0, 0, DateTimeZone.UTC );

}