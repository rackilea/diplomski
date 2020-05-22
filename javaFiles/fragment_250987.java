private BroadcastReceiver stopBr = new BroadcastReceiver() {
@Override
public void onReceive(Context context, Intent intent) {
    if ("stop_kill".equals(intent.getAction())) {
         stopself();
    }
}
};