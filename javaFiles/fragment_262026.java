SwingWorker worker=new SwingWorker()
{
    protected Object doInBackground()
    {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ex){}
        return null;
    }

    // This is executed within the context of the EDT AFTER the worker has completed...    
    public void done() {
        jLabel1.setText(jLabel1.getText()+".");
    }
};
worker.execute();