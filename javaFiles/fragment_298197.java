// the service class

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/**
 * JobService to be scheduled by the JobScheduler.
 * start another service
 */
public class mService extends JobService {
    private static final String TAG = "SyncService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("TAG", "onStartJobb");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("TAG", "onStopJob");
        return true;
    }
}


// in main activity

@RequiresApi(api = Build.VERSION_CODES.N)
public void onResume(){
    super.onResume();

    JobScheduler scheduler = getSystemService(JobScheduler.class);

    if(scheduler.getPendingJob(1) == null) {

        ComponentName componentName = new ComponentName(this, mService.class);
        //JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        JobInfo.Builder info = new JobInfo.Builder(1, componentName)
                .setRequiresCharging(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setMinimumLatency(1 * 1000)
                .setOverrideDeadline(3 * 1000)
                //.setPeriodic(60 * 60 * 1000)
                //.build()
                ;

        int resultCode = scheduler.schedule(info.build());
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("TAG", "Service is not running, Job " + String.valueOf(1) + " Scheduled.");
        } else {
            Log.d("TAG", "Service is not running, However job scheduling failed.");
        }

    } else{
        Log.d("TAG", "Service is already scheduled.");
    }
}

    // and in manifest

    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

    <service
        android:name=".mService"
        android:enabled="true"
        android:exported="true"
        android:label="Word service"
        android:permission="android.permission.BIND_JOB_SERVICE">
    </service>