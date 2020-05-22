Trigger trigger = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
        .onEveryDay()
        .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0))
        .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(12, 0))
        .withIntervalInMinutes(20)
        .build();