// Given a string of the form HHMM, this returns the number of minutes after midnight.
// For example: timeStringToMinutes("0000") -> 0.
// timeStringToMinutes("0015") -> 15.
// timeStringToMinutes("0100") -> 60.
// timeStringToMinutes("0837") -> 517.
// timeStringToMinutes("2359") -> 1439.
static int timeStringToMinutes(String s) {
    return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2, 4));
}