ThingyWorker worker;

public void actionPerformed(ActionEvent e) {
    if( worker != null ) worker.cancel();
    worker = new ThingyWorker();
    worker.execute();
}

class ThingyWorker extends SwingWorker<YOURCLASS, Object> {
    @Override protected YOURCLASS doInBackground() throws Exception {
        return doSomeComputation(); // Should be interruptible
    }   
    @Override protected void done() {
        worker = null; // Reset the reference to worker

        YOURCLASS data;

        try {
            data = get();
        } catch (Exception e) { 
            // May be InterruptedException or ExecutionException                
            e.printStackTrace();
            return;
        }           

        // Do something with data
    }       
}