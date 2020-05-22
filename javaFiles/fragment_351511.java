public class SentMessage extends BroadcastReceiver {

private final String TAG = "SentMessage";

@Override
public void onReceive(Context context, Intent intent) {
    long _id = intent.getLongExtra(EXTRA_ID, -1);
    long protocol_id = intent.getLongExtra(EXTRA_PROTOCOL, -1);
    Log.d(TAG, "SentMessage");
    switch (getResultCode()) {
    case Activity.RESULT_OK:
        Log.d(TAG, "RESULT_OK");
        if (MessageData.sentMessage(_id, protocol_id)) {
            try {
                Database.messageSent(_id);
            } catch (DatabaseRowNotFoundException e) {
                Log.e(TAG, e.toString(), e);
            }
        }
        break;
    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
        Log.d(TAG, "RESULT_ERROR_GENERIC_FAILURE");
        MessageData.postponeMessage(_id);
        ApplicationData.hasSignal(false);
        break;
    case SmsManager.RESULT_ERROR_NO_SERVICE:
        Log.d(TAG, "RESULT_ERROR_NO_SERVICE");
        MessageData.postponeMessage(_id);
        ApplicationData.hasSignal(false);
        break;
    case SmsManager.RESULT_ERROR_NULL_PDU:
        Log.d(TAG, "RESULT_ERROR_NULL_PDU");
        break;
    case SmsManager.RESULT_ERROR_RADIO_OFF:
        Log.d(TAG, "RESULT_ERROR_RADIO_OFF");
        MessageData.postponeMessage(_id);
        ApplicationData.hasSignal(false);
        break;
    }

}