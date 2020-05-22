public class CustomPhoneStateListener extends PhoneStateListener {



private static final String TAG = "CustomPhoneStateListener";

public void onCallStateChange(int state, String incomingNumber){
//Here you recieve the phone state being changed and are able to get the number and state.  

 switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                    Log.d(TAG, "RINGING");
                  //Here you could count with for() for 20 seconds and then create a method to do what you want.
                    break;