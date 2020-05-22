FullCalendarScheduler calendar = ...

// ...

calendar.addTimeslotsSelectedListener((TimeslotsSelectedSchedulerEvent event) -> {
    Optional<Resource> resource = event.getResource();
    // ... do something with the resource
});