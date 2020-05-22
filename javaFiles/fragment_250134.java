final SmsManager sms = SmsManager.getDefault();

public void onReceive(Context context, Intent intent) {
    final Bundle bundle = intent.getExtras();
    String phone = "";
    SmsMessage smsMessage;

    try {

        if (bundle != null) {

            final Object[] pdu = (Object[]) bundle.get("pdu");

            for (int i = 0; i < pdu.length; i++) {

                 smsMessage = SmsMessage.createFromPdu((byte[]) pdu[i]);
                 phone = current.getDisplayOriginatingAddress();
            }
        }
    }
}