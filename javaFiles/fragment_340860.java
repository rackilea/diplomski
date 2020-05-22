String phoneState = intent.getStringExtra(Phone.STATE_KEY);
                mPhoneState = (Phone.State) Enum.valueOf(
                        Phone.State.class, phoneState);



public class PhoneState extends PhoneStateListener {

@Override
public void onCallStateChanged(int state, String incomingNumber) {
    switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:
            //Some Action
            break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
            break;
        case TelephonyManager.CALL_STATE_RINGING:
            //Some Action
            break;
        //case TelephonyManager.ANOTHER_STATE: ...
    }
    }
}