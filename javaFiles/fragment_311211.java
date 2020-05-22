public interface JobUpdate {
  void jobCompleted();
}

public JobRunner implements JobUpdate {
   @override
   public void jobCompleted() {
     // Our implemented callback method, called from Job
   }
}

public Job() {
  private JobUpdate update;

  public Job(JobUpdate update) {
    this.update = update;
  }

  public void runJob() {
    // at correct point, invoke the appropriate callback method
    jobUpdate.jobCompleted();
  }
}