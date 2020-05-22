public boolean includes(ZonedDateTime dateTime) {
    ZonedDateTime tmpStart = start;
    ZonedDateTime tmpEnd = end;

    int distance = (int) ChronoUnit.DAYS.between(start, dateTime) - 1;
    if (distance > 0) {
        int factor = (int) (distance / recurrence.getDays());
        if (factor > 0) {
            Period quickAdvance = recurrence.multipliedBy(factor);
            tmpStart = start.plus(quickAdvance);
            tmpEnd = end.plus(quickAdvance);
        }
    }

    while (!tmpStart.isAfter(dateTime)) { // includes equality - okay for you?
        if (tmpEnd.isAfter(dateTime)) {
            return true;
        }
        tmpStart = tmpStart.plus(recurrence);
        tmpEnd = tmpEnd.plus(recurrence);
    }

    return false;
  }