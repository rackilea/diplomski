@Override
public void handleMessage(Message message) {
    switch (message.what) {
        case MY_MESSAGE_ID:
            repeat.setText("Repeat: " + message.arg1);
            break;

        default:
            Log.w(TAG, "Invalid message received: " + message.what);
            break;
    }
}