LocalTime currentTime = LocalTime.now(ZoneId.of("Asia/Qatar"));

int currentHours = currentTime.get(ChronoField.HOUR_OF_AMPM);
int currentMinutes = currentTime.getMinute();

System.out.println("Current time of the day using LocalTime - 12 hour format: "
        + currentHours + " HOURS " + currentMinutes + " MINUTES");