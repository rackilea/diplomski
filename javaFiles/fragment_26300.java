package com.basilbourque.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExportToCsv {
    public static void main ( String[] args ) {
        ExportToCsv app = new ExportToCsv();
        app.doIt();
    }

    private void doIt () {
        System.out.println( "TRACE - doIt running at " + ZonedDateTime.now() );
        List< Event > events = List.of(
        new Event( UUID.randomUUID() , "alpha" , Instant.now() ) ,
        new Event( UUID.randomUUID() , "beta" , Instant.now() ) ,
        new Event( UUID.randomUUID() , "gamma" , Instant.now() )
        );

        Runnable task = new Runnable() {
            @Override
            public void run () {
                // Nest all this stuff of your `run` method into a `try-catch( Exception e )` to avoid having your executor cease silently.
                Instant start = Instant.now();
                System.out.print( "TRACE - Runnable starting at " + start + ". " );
                // Update the moment recorded in each `Event` object.
                events.forEach( ( event ) -> event.update() );
                // Export to CSV. Using “Apache Commons CSV” library. https://commons.apache.org/proper/commons-csv/
                // Get current moment in UTC. Lop off the seconds and fractional second. Generate text without delimiters.
                String dateTimeLabel = OffsetDateTime.now( ZoneOffset.UTC ).truncatedTo( ChronoUnit.MINUTES ).format( DateTimeFormatter.ofPattern( "uuuuMMdd'T'HHmmX" , Locale.US ) );
                String fileNamePath = "myCsv_" + dateTimeLabel + ".csv";
                try (  // Try-with-resources syntax automatically closes any passed objects implementing `AutoCloseable`, even if an exception is thrown.
                BufferedWriter writer = new BufferedWriter( new FileWriter( fileNamePath ) ) ;
                CSVPrinter csvPrinter = new CSVPrinter( writer , CSVFormat.DEFAULT.withHeader( "Id" , "Name" , "When" ) ) ;
                ) {
                    for ( Event event : events ) {
                        csvPrinter.printRecord( event.id , event.name , event.when );
                    }
                    csvPrinter.flush();
                } catch ( IOException e ) {
                    // TODO: Handle i/o exception when creating or writing to file in storage.
                    e.printStackTrace();
                }
                Instant stop = Instant.now() ;
                System.out.println( "Runnable ending its run at " + start + ". Duration: " + Duration.between( start , stop ) + ".");
            }
        };

        // Schedule this task. Currently set to run every two minutes, ending after 20 minutes. Adjust as desired.
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();  // Using a single thread here, as we have only a single series of tasks to be executed, no multi-tasking. 
        try {
            scheduledExecutorService.scheduleAtFixedRate( task , 0 , 2 , TimeUnit.MINUTES );  // Schedule our task to run every so often.
            try {
                Thread.sleep( TimeUnit.MINUTES.toMillis( 20 ) );  // Sleep this main thread for a while to let our task running on the background thread do its thing a few times.
            } catch ( InterruptedException e ) {
                System.out.println( "TRACE - Our main thread was woken earlier than expected, and interrupted our run. " );
                e.printStackTrace();
            }
        } finally {
            System.out.println( "Shutting down the scheduledExecutorService at " + ZonedDateTime.now() );  // Generally best to log in UTC, `Instant.now()`.
            scheduledExecutorService.shutdown();  // Always shutdown your executor, as it may otherwise survive your app exiting, becoming a zombie, continuing to run endlessly.
        }
        System.out.println( "App running on main thread ending at " + Instant.now() + "." );
    }

    class Event {
        public UUID id;
        public String name;
        public Instant when;

        public Event ( UUID id , String name , Instant when ) {
            this.id = id;
            this.name = name;
            this.when = when;
        }

        public void update () {
            this.when = Instant.now();
        }
    }
}