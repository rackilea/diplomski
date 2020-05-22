ComponentName serviceName = new ComponentName(getPackageName(), mService.class.getName());

long min = JobInfo.getMinPeriodMillis();
JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName)
        .setRequiredNetworkType(NETWORK_TYPE_NONE)
        .setRequiresDeviceIdle(false)
        .setPeriodic(5000)
        .setRequiresCharging(false);
builder.setPeriodic(5 * 1000);

JobInfo myJobInfo = builder.build();
JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
jobScheduler.schedule(myJobInfo);