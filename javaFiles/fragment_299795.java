ProgressBarSwingWorker previous=null;
for(final ProgressBarSwingWorker p: progressList)
{
  if(previous==null) p.execute();
  else previous.addPropertyChangeListener(new PropertyChangeListener()
  {
    public void propertyChange(PropertyChangeEvent evt)
    {
      if("state".equals(evt.getPropertyName())
      && evt.getNewValue() == SwingWorker.StateValue.DONE)
        p.execute();
    }
  });
  previous=p;
}