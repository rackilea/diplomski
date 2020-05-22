// Example: forwardNumberOfMinutes("1240", "1028") -> 1308.
static int forwardNumberOfMinutes(String start, String end) {
    int from = timeStringToMinutes(start);
    int to   = timeStringToMinutes(end);
    if (to < from)
        to += 1440;  // 1 day, or 24 hours
    return to - from;
}