public class GCMIntentService extends JobIntentService {

    // Service unique ID
    static final int SERVICE_JOB_ID = 50;

    // Enqueuing work in to this service.
    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, GCMIntentService.class, SERVICE_JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        onHandleIntent(intent);
    }

    private void onHandleIntent(Intent intent) {
        //Handling of notification goes here
    }
}