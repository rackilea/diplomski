private BroadcastReceiver smsReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle myBundle = intent.getExtras();
            SmsMessage[] messages = null;
            if (myBundle != null) {
                Object[] pdus = (Object[]) myBundle.get("pdus");

                messages = new SmsMessage[pdus.length];

                for (int i = 0; i < messages.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = myBundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    }
                        /*strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                        strMessage += " : ";
                        strMessage += messages[i].getMessageBody();
                        strMessage += "\n";*/
                }
                if (messages[0].getMessageBody().substring(11).contains("OTP")){
                    final Pattern p = Pattern.compile( "(\\d{4})" );
                    final Matcher m = p.matcher(messages[0].getMessageBody().substring(11));
                    if ( m.find() ) {
                        Log.e("SMSotp", String.valueOf(m.group()));
                    }
                    String[] tet = m.group().split("(?!^)");

                    otp1.setText(tet[0]);
                    otp2.setText(tet[1]);
                    otp3.setText(tet[2]);
                    otp4.setText(tet[3]);


                }
            }

        }
    };