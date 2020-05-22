class MyActivity extends Activity {
    Job job;

    void onCreate(Bundle bundle) {
        job = (Job) getNonConfigurationInstance();
    }

    void onResume() {
        if (job != null) {
            job.attachActivity(this);
        }
    }

    void onPause() {
        if (job != null) {
            job.detachActivity();
        }
    }

    Object onRetainNonConfigurationInstance() {
        return job;
    }

    // create and start your job somewhere between onCreate and onPause
}