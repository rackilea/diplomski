public (abstract if you want to extend and add something on top) class WorkerThread extends Thread {

    private static final String TAG = WorkerThread();
    private List<WorkTask> syncQueue = new ArrayList< WorkTask >();
    private boolean clearQueue = false;
    public WorkerThread() {

    }


    public void stopThread(boolean clear) {
        clearQueue = clear;
        this.stopWorker = true;
    }

    public void addTask(WorkerTask task) {
        synchronized (syncQueue) {
            if (task != null && !getSynQueue().contains(task)) {
                getSynQueue().add(task);
            }
        }
    }

    public List<WorkerTask> getSynQueue() {
        return this.syncQueue;
    }

    @Override
    public void run() {
        while (!stopWorker) {
            WorkerTask task = null;
            synchronized (syncQueue) {
                if (!getSynQueue().isEmpty()) {
                    task = getSynQueue().get(0);
                }
            }
            if (task != null) {
                try {
                    task.run();
                    synchronized (syncQueue) {
                        if (!getSynQueue().isEmpty()) {
                            getSynQueue().remove(task);
                            //notify something/someone
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error in running the task." + e.getMessage());
                    synchronized (syncQueue) {
                       //again u can notify someone
                    }
                } finally {
                    //here you can actually notify someone of success
                }
            }
        }
        if(clearQueue){
           getSynQueue().clear();
        }
    }
}