public class MyFirebaseMessagingService extends FirebaseMessagingService {

@Override
public void onNewToken(String s) {
    super.onNewToken(s);
    // Save the new token here in a place from where you want to fetch it and send notification
    Log.e("NEW_TOKEN",s);
    }
}