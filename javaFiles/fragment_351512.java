public class DeliveredMessage extends BroadcastReceiver {

private final String TAG = "DeliveredMessage ";


@Override
public void onReceive(Context context, Intent intent) {

    long _id = intent.getLongExtra(EXTRA_ID, -1);
    long protocol_id = intent.getLongExtra(EXTRA_PROTOCOL, -1);
    switch (getResultCode()) {
    case Activity.RESULT_OK:
        if (_id != -1 && MessageData.deliveredMessage(_id, protocol_id)) {
            try {
                Database.messageDelivered(_id);
                Cursor messageCursor = Database.getCursorByID(MessageOutboxContentProvider.CONTENT_URI, MessageOutboxContentProvider._ID, _id);
                messageCursor.close();
            } catch (DatabaseRowNotFoundException e) {
                Log.e(TAG, e.toString(), e);
            }
        }
        break;
    case Activity.RESULT_CANCELED:
        break;
    }
}