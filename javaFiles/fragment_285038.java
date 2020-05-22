private DateTime roundDate(final DateTime dateTime, final int minutes) {
    if (minutes < 1 || 60 % minutes != 0) {
        throw new IllegalArgumentException("minutes must be a factor of 60");
    }

    final DateTime hour = dateTime.hourOfDay().roundFloorCopy();
    final long millisSinceHour = new Duration(hour, dateTime).getMillis();
    final int roundedMinutes = ((int)Math.round(
        millisSinceHour / 60000.0 / minutes)) * minutes;
    return hour.plusMinutes(roundedMinutes);
}