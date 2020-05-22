public void onSendClick(View view) {
        //checkRecipients();
        //countSMSChars();
        if(message.length() < 5){
            Toast.makeText(getBaseContext(), "Invalid message format/length.", Toast.LENGTH_SHORT).show();
            Log.d("Message: ",""+"Invalid message format/length: "+message.length());
        }else if(charLength > maxLen ){
            Toast.makeText(getApplicationContext(), "Maximum allowed characters is: "+maxLen, Toast.LENGTH_LONG).show();
        }else{SENDMESSAGE();}
    }
public void SENDMESSAGE(){
        sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure - Please check your delimiter settings or check your account balance.",
                                Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS delivered",
                                Toast.LENGTH_LONG).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered",
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        try{

            runSendMessage();
        }catch (Exception e){
            Log.d("Error: ", ""+e);
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public void runSendMessage(){
        try{
            checkDelimiterMode();//check the array split delimiter symbol
            message = input.getText().toString(); //get the message to be sent
            numbers = phoneNumbers.getText().toString();//get the recipients' numbers
            //split the numbers array using the delimiter
            String[] eachNumber = numbers.split(delimiterValue);
            smsCount = 0; SMSAmount = 4.00;
                for(String num:eachNumber){
                    Thread.sleep(3000);
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(num, null, message, sentPI, deliveredPI);
                    smsCount = smsCount+1; pb.incrementProgressBy((eachNumber.length*100)/100);
                    Toast.makeText(this,smsCount+" SMS sent @ N"+SMSAmount+" = N"+(SMSAmount*smsCount) , Toast.LENGTH_LONG).show();
                    Log.d("Number of SMS sent...",""+smsCount+" @ N"+SMSAmount+" = N"+(SMSAmount*smsCount));
                }
            }catch (Exception e){
            Log.d("Error: ", ""+e);
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
        }
    }