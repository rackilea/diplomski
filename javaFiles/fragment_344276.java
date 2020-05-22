DateTime currentTime = new DateTime();
    DateTime dateResult;
    boolean shouldReturnLastMonday = (currentTime.getDayOfWeek() != DateTimeConstants.MONDAY ||
            currentTime.hourOfDay().get() < 2);
    if (shouldReturnLastMonday) {
        dateResult = currentTime.minus(Days.days(currentTime.getDayOfWeek() - DateTimeConstants.MONDAY))
                .minus(currentTime.getMillisOfDay())
                .plus(Hours.hours(2));
    } else {
        dateResult = currentTime.minus(currentTime.getMillisOfDay())
                .plus(Hours.hours(2));
    }
    System.out.println(dateResult);