this.smsReceiverObj = new SmsReceiver(new SmsReceiver.OnCustomReceiveSMS() {
                @Override
                public void OnReceiveSMS(String inNumber, String inText) {
                    Toast.makeText(getApplicationContext(), "test event listener fired", Toast.LENGTH_SHORT).show();
                }
            });
registerReceiver(this.smsReceiverObj,new IntentFilter());