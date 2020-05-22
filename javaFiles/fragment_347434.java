class Job extends Thread {
    Activity activity;
    boolean needsFinishing;

    Job(Activity activity) {
        this.activity = activity;
    }

    synchronized void detachActivity() {
        activity = null;
    }

    synchronized void attachActivity(Activity activity) {
        this.activity = activity;
        if (needsFinishing) {
            finished();
        }
    }

    public void run() {
        // do long running job

        finished();
    }

    synchronized void finished() {
        if (activity != null) {
            needsFinishing = false;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    // do your stuff with the activity
                }
            });
        } else {
            needsFinishing = true;
        }
    }
}