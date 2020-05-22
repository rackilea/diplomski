newTrigger().
  withSchedule(
    simpleSchedule().
      withIntervalInHours(24).
      repeatForever()
    ).build();