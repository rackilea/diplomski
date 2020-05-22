   public class CallComplete extends BroadcastReceiver {
      public void onReceive(Context context, Intent intent) {
        
      try {

                TelephonyManager tmgr = (TelephonyManager) context
                        .getSystemService(Context.TELEPHONY_SERVICE);
                        
                MyPhoneStateListener PhoneListener = new MyPhoneStateListener();
                
                tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        
        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }

     }

     private class MyPhoneStateListener extends PhoneStateListener {
        public void onCallStateChanged(int state, String phoneNumber) {
        
            Log.d("MyPhoneListener",state+"   incoming no:"+phoneNumber);

            // zero state is CALL_STATE_IDLE
            if (state == 0) {

                String msg = "New Phone Call Event. Phone Number Number : "+phoneNumber;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(pcontext, msg, duration);
                toast.show();

            }
        }
    }
    }