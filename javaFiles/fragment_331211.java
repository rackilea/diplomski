Job job = new MyJob();

job.schedule();


class MyJob extends Job
{
  MyJob()
  {
    super("Job name");
  }

  public IStatus run(IProgressMonitor monitor) 
  {
    monitor.beginTask("Job", workCount);
    try
     {
        ... work
     }
    finally
     {
       monitor.done();
     }

    return Status.OK_STATUS;
  }
}