// Create a new PhoneStateListener
  listener = new PhoneStateListener() {
      @Override
      public void onCallStateChanged(int state, String incomingNumber) {

        switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:

          break;
        case TelephonyManager.CALL_STATE_OFFHOOK:

          break;
        case TelephonyManager.CALL_STATE_RINGING:
          // Ringing.. answer now
          telephonyService.answerRingingCall();
          break;
        }
   }