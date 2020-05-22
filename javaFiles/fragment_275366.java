....

final int minutes = (total_seconds / 60) % 60;
final int seconds = total_seconds % 60;

String paddedMinutes = String.format("%02d" , minutes);
String paddedSeconds = String.format("%02d" , seconds);

System.out.printf("You entered %d second(s), which is ", total_seconds);
if (hours == 0) {
    System.out.printf("%d minute(s), and %d second(s).\n",  minutes, seconds);
    System.out.print(paddedMinutes + ":" + paddedSeconds);
} else if ( ... ) {
    ...
}