public class WorkCounter {
    private int runningTasks;
    private final Context ctx;

    public WorkCounter(int numberOfTasks, Context ctx) {
        this.runningTasks = numberOfTasks;
        this.ctx = ctx;
    }
    // Only call this in onPostExecute! (or add synchronized to method declaration)
    public void taskFinished() {
        if (--runningTasks == 0) {
            LocalBroadcastManager mgr = LocalBroadcastManager.getInstance(this.ctx);
            mgr.sendBroadcast(new Intent("all_tasks_have_finished"));
        }
    }
}