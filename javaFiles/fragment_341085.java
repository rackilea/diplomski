package com.basilbourque.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDate {
    private LocalDate localDate;

    // Constructor
    public AppointmentDate ( LocalDate localDate ) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate ( ) {
        return localDate;
    }

    public void setLocalDate ( LocalDate localDate ) {
        this.localDate = localDate;
    }

    @Override
    public String toString ( ) {
        return "AppointmentDate{ " +
                "localDate=" + localDate +
                " }";
    }

    // Not really a part of this class. A `main` method is just a hack to get our app launched.
    public static void main ( String[] args ) {
        String input = "23/01/2018";
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
        LocalDate ld = LocalDate.parse( input , f );
        AppointmentDate ad = new AppointmentDate( ld );
        ad.setLocalDate( ld.plusWeeks( 1 ) );
        LocalDate newValue = ad.getLocalDate();
        System.out.println( newValue.toString() );  // Generate text representing the value of this `LocalDate` object in standard ISO 8601 format.

        List < AppointmentDate > list = new ArrayList <>( 3 );
        list.add( ad );
        list.add( new AppointmentDate( LocalDate.parse( "2018-02-13" ) ) );
        list.add( new AppointmentDate( LocalDate.parse( "2018-12-21" ) ) );
        System.out.println( list );
    }
}