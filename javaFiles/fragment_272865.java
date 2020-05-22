// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

String string = "10/15/2013 09:00 AM GMT+05:30";
DateTimeFormatter formatter = DateTimeFormat.forPattern( "MM/dd/yyyy hh:mm aaa zZ" );
DateTime dateTime = formatter.parseDateTime( string );
System.out.println( "dateTime: " + dateTime );