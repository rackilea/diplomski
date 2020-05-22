package com.basilbourque.example;

import java.time.*;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// This class follows the lead of the `java.time.Year` class.
// See JavaDoc: https://docs.oracle.com/javase/10/docs/api/java/time/Year.html
// See OpenJDK source-code: http://hg.openjdk.java.net/jdk10/master/file/be620a591379/src/java.base/share/classes/java/time/Year.java
// This class follows the immutable objects pattern. So only getter accessor methods, no setters.
public class AcademicYear {
    // Statics
    static public int FIRST_YEAR_LIMIT = 2017;
    static public int FUTURE_YEARS_LIMIT = 10;
    static public Set < Month > academicYearStartingMonths = EnumSet.of( Month.NOVEMBER , Month.DECEMBER );

    // Members
    private int academicYearNumberStart;

    // Constructor
    private AcademicYear ( int academicYearNumberStart ) {
        if ( academicYearNumberStart < AcademicYear.FIRST_YEAR_LIMIT ) {
            throw new IllegalArgumentException( "Received a year number: " + academicYearNumberStart + " that is too long ago (before " + AcademicYear.FIRST_YEAR_LIMIT + "). Message # c5fd65c1-ed10-4fa1-96db-77d08ef1d97e." );
        }
        if ( academicYearNumberStart > Year.now().getValue() + AcademicYear.FUTURE_YEARS_LIMIT ) {
            throw new IllegalArgumentException( "Received a year number that is too far in the future, over " + AcademicYear.FUTURE_YEARS_LIMIT + " away. Message # 8581e4ca-afb3-4ab7-8849-9b02c434eb4c." );
        }
        this.academicYearNumberStart = academicYearNumberStart;
    }

    public static AcademicYear of ( int academicYearNumberStart ) {
        return new AcademicYear( academicYearNumberStart );
    }

    public int getValueStart ( ) {
        return this.academicYearNumberStart;
    }

    public int getValueStop ( ) {
        return ( this.academicYearNumberStart + 1 );
    }

    public String getDisplayName ( ) {
        String s = this.academicYearNumberStart + "-" + ( this.academicYearNumberStart + 1 );
        return s;
    }

    // ------| `Object`  |---------------------

    @Override
    public String toString ( ) {
        return "AcademicYear{ " +
                "academicYearNumberStart=" + academicYearNumberStart +
                " }";
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        AcademicYear that = ( AcademicYear ) o;
        return this.getDisplayName().equals( that.getDisplayName() );
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash( this.getDisplayName() );
    }

    // -----------|  Factory methods  |-------------------

    static public AcademicYear now ( ) {  // I think making ZoneId optional is a poor design choice, but I do so here to mimic `java.time.Year`.
        AcademicYear ay = AcademicYear.now( Clock.systemDefaultZone() );
        return ay;
    }

    static public AcademicYear now ( ZoneId zoneId ) {
        // Determine the current date as seen in the wall-clock time used by the people of a particular region (a time zone).
        AcademicYear ay = AcademicYear.now( Clock.system( zoneId ) );
        return ay;
    }

    static public AcademicYear now ( Clock clock ) {
        final LocalDate localDate = LocalDate.now( clock );
        AcademicYear ay = AcademicYear.from( localDate );
        return ay;
    }

    static public AcademicYear from ( LocalDate localDate ) {
        Objects.requireNonNull( localDate , "Received a null `LocalDate` object. Message # 558dd5e8-5cff-4c6e-b0f8-40dbcd76a753." );
        // Extract the month of the specified date. If not Nov or Dec, subtract one from the year.
        int y = localDate.getYear();
        // If not November or December, subtract 1.
        int startingYear;
        if ( ! academicYearStartingMonths.contains( localDate.getMonth() ) ) {
            startingYear = ( y - 1 );
        } else {
            startingYear = y;
        }
        AcademicYear ay = AcademicYear.of( startingYear );
        return ay;
    }

}