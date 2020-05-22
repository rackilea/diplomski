public Consumer<Entry> createConsumer(Calendar calendar, Set<Alarm> alarms, List<DateTime> dates) {
    return entry -> {
        LocalTime time = entry.getDate().toLocalTime();
        Alarm alarm = new Alarm(time, calendar.getPattern());
        alarms.add(alarm);
        dates.add(entry.getDate());
    }
}