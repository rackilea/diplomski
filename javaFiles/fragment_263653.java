@Override
public void onDestroy() {
    super.onDestroy();
    Intent broadcastIntent = new Intent(".RestartService");
    sendBroadcast(broadcastIntent);
}