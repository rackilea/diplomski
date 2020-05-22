public class MainActivity extends Activity implements OnClickListener {


TextView CurStrgth;
MyPhoneStateListener MyListener;
TelephonyManager Tel;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CurStrgth = (TextView) findViewById(R.id.tvCurCellStrength);

    MyListener = new MyPhoneStateListener();

    Tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    Tel.listen(MyListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);


}


@Override
protected void onPause() {
    super.onPause();
    Tel.listen(MyListener, PhoneStateListener.LISTEN_NONE);
}

@Override
protected void onResume() {
    super.onResume();
    Tel.listen(MyListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
}

private class MyPhoneStateListener extends PhoneStateListener {
    String gsmStrength = "";

    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
            gsmStrength = String
                .valueOf(signalStrength.getGsmSignalStrength() * 2 - 113);
        CurStrgth.setText(MyListener.getStrength() + "dBm");
    }

    public String getStrength() {
        return gsmStrength;
    }

}
}