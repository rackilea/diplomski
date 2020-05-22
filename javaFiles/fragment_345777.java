public class UfkJob implements IScheduledJob {

  String jobName;
  ISchedulingService service;

  public UfkJob(ISchedulingService service){
    this.service = service;
    this.jobName = service.addScheduledJobAfterDelay(5000, this, 200);
  }
  public void execute(ISchedulingService service) {
    if (...) {
      service.removeScheduledJob(jobName);
    }
  }

}

//Your calling code
...
new UfkJob((ISchedulingService) getScope().getContext().getBean(ISchedulingService.BEAN_NAME));