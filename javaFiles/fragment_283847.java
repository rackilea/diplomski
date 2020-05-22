import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;
import java.util.TreeSet;

public class RegistrationIntentService extends IntentService {


    Intent registrationComplete;
    private SharedPreferencesHelper sharedPreferencesHelper;

    public RegistrationIntentService() {
        super("TokenRegistration");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        registrationComplete = new Intent(GCMConstants.REGISTRATION_COMPLETE);

        InstanceID instanceID = InstanceID.getInstance(this);

        try {
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            sharedPreferencesHelper.setGCMID(token);

            subscribeTopics(token);

            sharedPreferencesHelper.tokenStatus(true);
        } catch (IOException e) {
            if (e.getMessage().equals("SERVICE_NOT_AVAILABLE")) {
                registrationComplete.putExtra("Error", Constants.NO_INTERNET);
            }
            sharedPreferencesHelper.tokenStatus(false);
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void subscribeTopics(String token) throws IOException {
        TreeSet<String> TOPICS = new TreeSet<>();

        TOPICS.add("BookThatUpdates");

        sharedPreferencesHelper.setGCMTopics(TOPICS);

        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }
}