final FileLoadWorker worker = new FileLoadWorker(f, pm);

worker.addPropertyChangeListener(new PropertyChangeListener()
{
    @Override
    public void propertyChange(final PropertyChangeEvent evt)
    {
        if("progress".equalsIgnoreCase(evt.getPropertyName())) 
        {
            pm.setProgress((int) evt.getNewValue());
        }

        if("state".equals(evt.getPropertyName())) 
        {
            SwingWorker.StateValue s = (SwingWorker.StateValue) evt.getNewValue();
            if(s.equals(SwingWorker.StateValue.DONE))
            {
                pm.setProgress(100);
                pm.close();
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if(pm.isCanceled())
        {
            pm.close();
            worker.cancel(true);
        }
    }
});
worker.execute();