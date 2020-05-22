List<LocalTime> result = new ArrayList<>();
    String start = "06:00:00";
    String finish = "22:00:00";

    LocalTime startTime = LocalTime.parse(start);
    LocalTime endTime = LocalTime.parse(finish);

    Duration totalTime = Duration.between(startTime, endTime);
    int subintervalCount = 5;
    Duration subintervalLength = totalTime.dividedBy(subintervalCount);

    LocalTime currentTime = startTime;
    for (int i = 0; i < subintervalCount; i++) {
        result.add(currentTime);
        currentTime = currentTime.plus(subintervalLength);
    }

    System.out.println(result);