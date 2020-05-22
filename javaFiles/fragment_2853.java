static String getTimeBetween(ZonedDateTime from, ZonedDateTime to) {
    StringBuilder builder = new StringBuilder();
    long epochA = from.toEpochSecond(), epochB = to.toEpochSecond();
    long secs = Math.abs(epochB - epochA);
    if (secs == 0) return "now";
    Map<String, Integer> units = new LinkedHashMap<>();
    units.put("day", 86400);
    units.put("hour", 3600);
    units.put("minute", 60);
    units.put("second", 1);
    boolean separator = false;
    for (Map.Entry<String, Integer> unit : units.entrySet()) {
        if (secs >= unit.getValue()) {
            long count = secs / unit.getValue();
            if (separator) builder.append(", ");
            builder.append(count).append(' ').append(unit.getKey());
            if (count != 1) builder.append('s');
            secs %= unit.getValue();
            separator = true;
        }
    }
    return builder.append(epochA > epochB ? " ago" : " in the future").toString();
}