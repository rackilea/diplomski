public class NetworkService extends IntentService {

 @Override
 protected void onHandleIntent(Intent intent) {
     if (intent != null) {
         ResultReceiver reciever = intent.getParcelableExtra(MyReciever.RESULT_RECEIEVER_EXTRA);
    }
}