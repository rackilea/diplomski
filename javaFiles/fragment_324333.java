// note the Java naming convention:
// variable names should start in lower case.
String flightTimeHours = String.format("%s0:%.6f", Hh, FM);

// a pedantic version, with constant locale and parameter ordering
String flightTimeHours = String.format(Locale.US, "%1$s0:%2$.6f", Hh, FM);