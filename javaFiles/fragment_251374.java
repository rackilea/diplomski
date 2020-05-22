//Create a new Job 
JobKey jobKey = JobKey.jobKey("myNewJob", "myJobGroup");
JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity(jobKey).storeDurably().build();

//Register this job to the scheduler
scheduler.addJob(job, true);

//Immediately fire the Job MyJob.class
scheduler.triggerJob(jobKey);