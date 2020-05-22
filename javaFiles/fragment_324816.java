SmsManager smsManager = SmsManager.getDefault ();

String message = "My location: https://www.google.com/maps/@?api=1&map_action=map&center=" + location.getLatitude () + "," + location.getLongitude ();
String phoneNumber = "+1....";

smsManager.sendTextMessage (phoneNumber, null, message, null, null);