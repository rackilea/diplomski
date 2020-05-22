public class Job {
  public enum JobLifecycle  {
    New, inTransit, inStorage, delivered, signedOff;
  }

  ...// other fields omitted
  JobLifecycle lifecycle;

  public Job(){
  }


  @Exclude
  public JobLifecycle getLifecycleAsEnum(){
    return lifecycle;
  }

  // these methods are just a Firebase 9.0.0 hack to handle the enum
  public String getLifecycle(){
    if (lifecycle == null){
      return null;
    } else {
      return lifecycle.name();
    }
  }

  public void setLifecycle(String lifecycleString){
    if (lifecycleString == null){
      lifecycle = null;
    } else {
      this.lifecycle = JobLifecycle.valueOf(lifecycleString);
    }
  }
}