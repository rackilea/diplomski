class ProgressBarSwingWorker extends SwingWorker<Object, Object>
{
  ProgressBarSwingWorker next;
  // …
  public ProgressBarSwingWorker(ProgressBarSwingWorker nextWorker)
  {
    next=nextWorker;
  }
  // …
  @Override
  protected void done()
  {
    if(next!=null) next.execute();
  }
}