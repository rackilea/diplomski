String interval = "04:00 PM - 04:30 PM";
    String[] selectedTime = interval.split(" - ");
    DateTimeFormatter parser = DateTimeFormat.forPattern("hh:mm a");
    LocalDate today = new LocalDate(DateTimeZone.getDefault());
    LocalTime tStart = parser.parseLocalTime(selectedTime[0]);

    String startTime = today.toLocalDateTime(tStart).toString();
    System.out.println("Start time: " + startTime);