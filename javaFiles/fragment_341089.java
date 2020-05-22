package com.basilbourque.example;

import org.threeten.extra.Interval;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// An example class to show date-time handling for future appointments.
// Not necessarily ready for production use. Use at your own risk.
// Methods named according to the java.time naming conventions:
// https://docs.oracle.com/javase/tutorial/datetime/overview/naming.html
public class Appointment {
    private LocalDateTime start;
    private Duration duration;

    // Constructor.
    public Appointment ( LocalDateTime start , Duration duration ) {
        this.start = start;
        this.duration = duration;
    }

    // Dynamically determine the start and stop points of this appointment, given today’s definition of the intended time zone.
    public Interval toInterval ( ZoneId zoneId ) {
        Objects.requireNonNull( zoneId , "Must pass a time zone to get the start/stop interval of an appointment. Message # bbf021e6-baa7-468d-83ad-cf73acb6702e." );
        ZonedDateTime zdtStart = this.start.atZone( zoneId );
        Interval interval = Interval.of( zdtStart.toInstant() , this.duration );
        return interval;
    }

    // Get start moment for a particular time zone.
    public ZonedDateTime toStartMoment ( ZoneId zoneId ) {
        ZonedDateTime zdt = this.toInterval( zoneId ).getStart().atZone( zoneId );
        return zdt;
    }

    // Get stop moment for a particular time zone.
    public ZonedDateTime toStopMoment ( ZoneId zoneId ) {
        ZonedDateTime zdt = this.toInterval( zoneId ).getEnd().atZone( zoneId );
        return zdt;
    }

    // Dynamically determine if this appointment will be in the future for some specific time zone.
    public Boolean isFuture ( ZoneId zoneId ) {
        Objects.requireNonNull( zoneId , "Must pass a time zone to determine if an appointment is in the future. Message # e1c64bc1-9a44-4d15-b20d-e68414fb5ab5." );
        ZonedDateTime zdtStart = this.start.atZone( zoneId );
        ZonedDateTime zdtNow = ZonedDateTime.now( zoneId );
        boolean isInTheFuture = zdtNow.isBefore( zdtStart );
        return isInTheFuture;
    }

    // -----------|  Object overrides  |---------------------------
    @Override
    public String toString ( ) {
        return "Appointment{ " +
                "start=" + start +
                " | duration=" + duration +
                " }";
    }

    // -----------|  main  |-------------
    public static void main ( String[] args ) {
        // See if a new appointment is in the future.
        Appointment a = new Appointment( LocalDateTime.of( 2018 , 12 , 25 , 0 , 0 , 0 , 0 ) , Duration.ofHours( 2 ) );  
        ZoneId z = ZoneId.of( "America/Montreal" );
        System.out.println( "For time zone: " + z + ", appointment interval is: " + a.toInterval( z ) );
        System.out.println( "Start: " + a.toStartMoment( z ) );
        System.out.println( "Stop: " + a.toStopMoment( z ) );

        Boolean isFuture = a.isFuture( z );
        System.out.println( a.toString() + " is future t/f: " + isFuture );

        // Collect some appointments.
        List < Appointment > list = new ArrayList <>( 3 );
        list.add( a );
        list.add( new Appointment( LocalDateTime.of( 2018 , 12 , 13 , 15 , 0 , 0 , 0 ) , Duration.ofMinutes( 90 ) ) );
        list.add( new Appointment( LocalDateTime.of( 2018 , 12 , 30 , 16 , 0 , 0 , 0 ) , Duration.ofHours( 1 ) ) );
        System.out.println( list );
    }

}