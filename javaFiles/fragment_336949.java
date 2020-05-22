/// Do not let this reference go out of scope!
PGNotificationListener listener = new PGNotificationListener() {

@Override
public void notification(int processId, String channelName, String payload) {
    // interesting code
};
pgConnection.addNotificationListener(listener);