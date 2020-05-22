@Scheduled(fixedRateString = "PT15S")
    @SchedulerLock(name = "copy_records")
    public void copyRecords()
    {
        // do smth on a single instance of an app only
    }