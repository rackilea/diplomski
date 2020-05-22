@Transactional
public void execute(JobExecutionContext context) throws JobExecutionException {
  super.logExecution(context);
  super.initialize(context);

  this.extractObjects();

  MyJob myJob = this.myJobRepository.findOne(super.applicationJob.getJobId());
  this.myJobRepository.refresh(myJob);
  this.myJobRepository.save(myJob);
}