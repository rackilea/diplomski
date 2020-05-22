String lastCalledNumber;

@Override
protected void onCreate(Bundle savedInstanceState) {
     // Same except without the `getLastOutgoingCall()`
}

@Override
public void onResume() {
    lastCalledNumber = CallLog.Calls.getLastOutgoingCall(this);
}