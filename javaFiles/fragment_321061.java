// in class - note that this will cache the current default timezone
private static final DateTime EPOCH_START_INSTANT = new DateTime(0);

// West of Greenwich, this will actually represent the "day" before.
// Day 0 will be Dec 31, 1969, local time.
DateTime localTime = EPOCH_START_INSTANT.plusDays(yourDayCount);