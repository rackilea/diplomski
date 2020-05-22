String defaultFormatted = dt.toString();
// this is what contains the "T11:47:29.229+01:00" part

DateTime dateTime = dtf.parseDateTime(defaultFormatted);
// we're back at the beginning, this is equivalent to your original "dt"

String defaultFormattedAgain = dateTime.toString();
// and this is the same as the initial string with T11:..