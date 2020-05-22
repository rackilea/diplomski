public class RestartAlarmsService extends IntentService{

    public RestartAlarmsService() {
        super("RestartAlarmsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // Restart your alarms here.
        // open database, iterate through every alarm and set them again

    }
}