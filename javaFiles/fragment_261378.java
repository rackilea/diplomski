private PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        // Test for incoming call, dialing call, active or on hold
        if (state==TelephonyManager.CALL_STATE_RINGING || state==TelephonyManager.CALL_STATE_OFFHOOK)
        {
            stop();  // Put here the code to stop your music
        }
        super.onCallStateChanged(state, incomingNumber);
    }
};