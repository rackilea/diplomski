public boolean isWithinInterval(LocalTime start, LocalTime end, LocalTime time) {
    if (start.isAfter(end)) {
        // Return true if the time is after (or at) start, *or* it's before end
        return time.compareTo(start) >= 0 ||
               time.compareTo(end) < 0;
    } else {
        return start.compareTo(time) <= 0 &&
               time.compareTo(end) < 0;
    }
}