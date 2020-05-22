public boolean isWithinInterval(LocalTime start, LocalTime end, LocalTime time) {
    if (start.isAfter(end)) {
        return !isWithinInterval(end, start, time);
    }
    // This assumes you want an inclusive start and an exclusive end point.
    return start.compareTo(time) <= 0 &&
           time.compareTo(end) < 0;
}