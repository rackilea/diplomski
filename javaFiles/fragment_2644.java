LocalTime tEnd = parser.parseLocalTime(selectedTime[1]);
    String endTime;
    if (tEnd.isBefore(tStart)) {
        // Assume that end time is after midnight, that is, tomorrow
        endTime = today.plusDays(1).toLocalDateTime(tEnd).toString();
    } else {
        // The normal case: both start and end times are today
        endTime = today.toLocalDateTime(tEnd).toString();
    }
    System.out.println("End time: " + endTime);