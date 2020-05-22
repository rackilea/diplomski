public class UfkJob implements IScheduledJob {

  String jobName = null;

 public void execute(ISchedulingService service) {
   if (... && jobName != null) {
   /* here i want to remove the current running job */
   ISchedulingService service = (ISchedulingService) getScope().getContext().getBean(ISchedulingService.BEAN_NAME);
   service.removeScheduledJob(jobName);
  }
  public void setJobName(String name){
    this.jobName = name;
  }
}