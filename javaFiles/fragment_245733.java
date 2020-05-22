Bundle extras = intent.getExtras();
GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
String messageType = gcm.getMessageType(intent);
if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType))
{
    //Here you process the intent like you normally would
    //String parameter = intent.getStringExtra("name of parameter");
    //...
    //After that you can create a notification like in the link below.
}