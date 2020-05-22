Object[][] data = new Object[9][2];
            int i=0;
            List<JobExecutionContext> sf = scheduler.getCurrentlyExecutingJobs();
            for (JobExecutionContext jobExecutionContext : sf) {

                data [i][0] = jobExecutionContext.getScheduler().getSchedulerName();
                data [i][1] = jobExecutionContext.getJobDetail().getDescription();
                i++;
            }