String smsBody = mynewsms.getMessageBody().toString();
String address = mynewsms.getOriginatingAddress();
if(dbHelper.isExists(address)){
      smsMessageStr += "SMS From: " + address + "\n";
      smsMessageStr += smsBody + "\n";
}