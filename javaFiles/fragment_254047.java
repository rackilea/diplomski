final Job job = new Job("Name")
{

  @Override
  protected IStatus run( final IProgressMonitor monitor )
  {
  // do something
    schedule( delay ) // schedule again after "delay" mili seconds
    return status;
  }
};
job.schedule();