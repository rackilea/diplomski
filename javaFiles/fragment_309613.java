class A implements Job {
  public void execute(JobExecutionContext context) throws JobExecutionException {
      // do A's stuff
      // call Job B somehow (???)
  }
}


class B implements Job {
  public void execute(JobExecutionContext context) throws JobExecutionException {
      // do something
  }