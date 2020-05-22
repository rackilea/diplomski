public void openURL(Context context) 
    {
     Intent intent = new Intent("com.ingage.pocs.phonegap.URL");
     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     context.startActivity(intent);
     }