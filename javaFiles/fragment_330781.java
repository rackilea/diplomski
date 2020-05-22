Job job1 = new Job("Job1");
Job job2 = new Job("job2");
....  // code which configure both the job objects.
//Now submit both the jobs.
job1.submit();
job2.submit();
// Wait for the completion.
while(!job1.isComplete() && !job2.isComplete()) {
     Thread.sleep(10000);
}