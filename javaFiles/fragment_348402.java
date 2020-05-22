SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
// If you set lenient to false, ranges will be checked, e.g.
// seconds must be in the range of 0..59 inclusive.
format.setLenient(false);

String timestamp = "2014-09-11T03:27:54";
ParsePosition pos = new ParsePosition(0);

format.parse(timestamp, pos); // No declared exception, no need try-catch

if (pos.getErrorIndex() >= 0) {
    System.out.println("Input timestamp is invalid!");
} else if (pos.getIndex() != timestamp.length()) {
    System.out.println("Date parsed but not all input characters used!"
         + " Decide if it's good or bad for you!");
} else {
    System.out.println("Input is valid, parsed completely.");
}