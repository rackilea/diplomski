String inputStart = "07:00";
String inputStop = "14:00";

LocalTime start = LocalTime.parse ( inputStart );
LocalTime stop = LocalTime.parse ( inputStop );
LocalTime nextTime = start;

Duration duration = Duration.ofMinutes ( 5 );

long initialCapacity = ( Duration.between ( start , stop ).toMinutes () / duration.toMinutes () ) + 1;  // Optional line of code.  Could be omitted.
List<LocalTime> times = new ArrayList ( ( int ) initialCapacity );
while (  ! nextTime.isAfter ( stop ) ) {
    times.add ( nextTime );
    nextTime = nextTime.plus ( duration );  //  Or call .plusMinutes( int ) and pass a number of minutes.
}