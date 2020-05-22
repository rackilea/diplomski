trigger = newTrigger()
.withIdentity("trigger3", "group1")
.startAt(tomorrowAt(15, 0, 0)  // 15:00:00 tomorrow
.withSchedule(calendarIntervalSchedule()
        .withIntervalInWeeks(2)) // interval is set in calendar weeks
.build();