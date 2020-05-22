String json = "Date(-62135510400000+0000)";
    String timeString = json.substring(json.indexOf("(") + 1, json.indexOf(")"));
    String[] timeSegments = timeString.split("\\+");
    // May have to handle negative timezones
    int timeZoneOffSet = Integer.valueOf(timeSegments[1]) * 36000; // (("0100" / 100) * 3600 * 1000)
    long millis = Long.valueOf(timeSegments[0]);
    Date time = new Date(millis + timeZoneOffSet);
    System.out.println(time);