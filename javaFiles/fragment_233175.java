import java.util.*;
import java.lang.*;
import java.io.*;

import java.time.* ;
import java.time.format.* ;
import java.time.temporal.* ;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List< Event > events = new ArrayList<>( 3 ) ;
        events.add( new Event( LocalDateTime.of( 2019 , 3 , 14 , 12 , 0 , 0 , 0 ) ) ) ;
        events.add( new Event( LocalDateTime.of( 2019 , 1 , 17 , 14 , 0 , 0 , 0 ) ) ) ;
        events.add( new Event( LocalDateTime.of( 2019 , 2 , 21 , 17 , 0 , 0 , 0 ) ) ) ;
        System.out.println("Before: " + events ) ;

        Collections.sort( events ) ;
        System.out.println("After: " + events ) ;
    }
}