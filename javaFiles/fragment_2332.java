// Convert input string to standard ISO 8601 format.
// Alternatively, you could use a formatter to parse your original string rather than convert.
String inputRaw = "33m03s";
String inputStandard = "PT" + inputRaw; // Assuming this is a time-only without date portion, prepend 'PT' to make standard ISO 8601 format.
inputStandard = inputStandard.toUpperCase();

// Parse string as Period object.
Period period = Period.parse( inputStandard );

// Convert from Period to Duration to extract total seconds.
Duration duration = period.toStandardDuration();
long durationInSeconds = duration.getStandardSeconds();  // Returns getMillis() / 1000. The result is an integer division, so 2999 millis returns 2 seconds.