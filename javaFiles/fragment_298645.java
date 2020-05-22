mPhoneStateReceiver = new PhoneStateIntentReceiver(this, new ServiceStateHandler());
mPhoneStateReceiver.notifyServiceState(MY_NOTIFICATION_ID);
mPhoneStateReceiver.notifyPhoneCallState(MY_NOTIFICATION_ID);
mPhoneStateReceiver.notifySignalStrength(MY_NOTIFICATION_ID);
mPhoneStateReceiver.registerIntent();

private class ServiceStateHandler extends Handler {
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MY_NOTIFICATION_ID:
                ServiceState state = mPhoneStateReceiver.getServiceState();
                System.out.println(state.getCid());
                System.out.println(state.getLac());
                System.out.println(mPhoneStateReceiver.getSignalStrength());
                break;
        }
    }
}