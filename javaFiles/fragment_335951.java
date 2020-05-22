Receiver receiver;
boolean isReciverRegistered = false;


@Override
public void onResume() {
    super.onResume();

    if (receiver == null) {
        receiver = new Receiver();
        IntentFilter filter = new IntentFilter(BroadcastHelper.ACTION_NAME);
        getActivity().registerReceiver(receiver, filter);
        isReciverRegistered = true;
    }
}

@Override
public void onDestroy() {
    if (isReciverRegistered) {
        if (receiver != null)
            getActivity().unregisterReceiver(receiver);
    }
    super.onDestroy();
}


private class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Log.v("r", "receive " + arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME));
        String methodName = arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME);
        if (methodName != null && methodName.length() > 0) {
            Log.v("receive", methodName);
            switch (methodName) {

                case "url":

                    /* call post method here */

                default:
                    break;
            }
        }
    }
}