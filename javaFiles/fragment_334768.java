class TeleListener extends PhoneStateListener {
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                // CALL_STATE_IDLE;
                Toast.makeText(getApplicationContext(), "CALL_STATE_IDLE",
                        Toast.LENGTH_LONG).show();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // CALL_STATE_OFFHOOK;
                Toast.makeText(getApplicationContext(), "CALL_STATE_OFFHOOK",
                        Toast.LENGTH_LONG).show();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                // CALL_STATE_RINGING
                Toast.makeText(getApplicationContext(), incomingNumber,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "CALL_STATE_RINGING",
                        Toast.LENGTH_LONG).show();
                break;
            default:
                break;
            }
        }
    }