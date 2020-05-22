// Listens for phone state and pauses in an event of call
    private final PhoneStateListener mPhoneListener = new PhoneStateListener() {
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            // Call receive state
            if (state != TelephonyManager.CALL_STATE_IDLE) {
                if ((play!= null) && (play.isPlaying())) 
                { 
                    play.pause(); 
                }
            }
        }
    };