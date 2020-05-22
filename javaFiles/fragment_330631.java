public void sendSMS(String phoneNo, String msg) {
try {      
    SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage(phoneNo, null, msg, null, null);    
    Toast.makeText(getApplicationContext(), "Message Sent",
          Toast.LENGTH_LONG).show();
} catch (Exception ex) {
    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
          Toast.LENGTH_LONG).show();
    ex.printStackTrace();
} 
}