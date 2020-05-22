package com.basilbourque.example;

import org.threeten.extra.Interval;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Appointment {
    private LocalDateTime start;
    private Duration duration;

    // Constructor.
    public Appointment ( LocalDateTime start , Duration duration ) {
        this.start = start;
        this.duration = duration;
    }

    // Might add some getter/setter methods in here.

    // Dynamically determine the start and stop points of this appointment, given today’s definition of the intended time zone.
    public Interval toInterval ( ZoneId zoneId ) {
        ZonedDateTime zdtStart = this.start.atZone( zoneId );
        Interval interval = Interval.of( zdtStart.toInstant() , this.duration );
        return interval;
    }

}