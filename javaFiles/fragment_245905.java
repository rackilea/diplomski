Bundle extras = intent.getExtras();

...

} else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
  String msg = extras.getString("msg");
  // Do something with msg
}