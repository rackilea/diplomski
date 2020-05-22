// TODO Update type params according to your needs.
public class MyAsyncTask extends AsyncTask<Void,Void,Void> {
    // This instance should be created before creating your async tasks.
    // Its start count should be equal to the number of async tasks that you will spawn.
    // It is important that the same AtomicInteger is supplied to all the spawned async tasks such that they share the same work counter.
    private final AtomicInteger workCounter;

    public MyAsyncTask(AtomicInteger workCounter) {
        this.workCounter = workCounter;
    }

    // TODO implement doInBackground

    @Override
    public void onPostExecute(Void result) {
        // Job is done, decrement the work counter.
        int tasksLeft = this.workCounter.decrementAndGet();
        // If the count has reached zero, all async tasks have finished.
        if (tasksLeft == 0) {
            // Make activity aware by sending a broadcast.
            LocalBroadcastManager mgr = LocalBroadcastManager.getInstance(this.ctx);
            mgr.sendBroadcast(new Intent("all_tasks_have_finished"));    
        }
    }
}