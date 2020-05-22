sms.OnSMSListener(new SendSMS.OnSMSListener() {
        @Override
        public void onSmsSent() {
            Toast.makeText(MainActivity.this, "SMS Sent", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onGenericFailure() {
            Toast.makeText(MainActivity.this, "Generic Failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNoService() {
            Toast.makeText(MainActivity.this, "No Service", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNullPdu() {
            Toast.makeText(MainActivity.this, "Null PDU", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRadioOff() {
            Toast.makeText(MainActivity.this, "Radio Off", Toast.LENGTH_SHORT).show();
        }
    });
    sms.sendMessage();