public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    List<TimeEntry> timeEntries = Arrays.asList(
        new TimeEntry(LocalDateTime.parse("2016-01-22 10:00", formatter), Duration.ofMinutes(5)),
        new TimeEntry(LocalDateTime.parse("2016-01-23 08:00", formatter), Duration.ofMinutes(7)),
        new TimeEntry(LocalDateTime.parse("2016-01-23 08:43", formatter), Duration.ofMinutes(3))
    );

    Map<Integer, Map<Integer, List<TimeEntry>>> map = 
        timeEntries.stream()
                   .collect(groupingBy(TimeEntry::getDay, groupingBy(TimeEntry::getHour)));

    List<Day> output =
        map.entrySet()
           .stream()
           .map(e -> {
              String dayName = e.getValue().values().iterator().next().get(0).getDayName();
              List<Hour> hours =
                 e.getValue().entrySet()
                             .stream()
                             .map(he -> new Hour(he.getKey(), sumDuration(he.getValue(), TimeEntry::getDuration), he.getValue()))
                             .collect(toList());
              return new Day(e.getKey(), dayName, sumDuration(hours, Hour::getSumOfEntries), hours);
           })
           .collect(toList());

    System.out.println(output);
}

private static <T> Duration sumDuration(List<T> list, Function<T, Duration> function) {
    return list.stream().map(function::apply).reduce(Duration.ofMinutes(0), (d1, d2) -> d1.plus(d2));
}