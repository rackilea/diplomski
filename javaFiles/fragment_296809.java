public void StartRegistrationNotification()
    {

        Intent registrationIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
        registrationIntent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
        registrationIntent.putExtra("sender", "....@gmail.com");
        this.startService(registrationIntent);  

}