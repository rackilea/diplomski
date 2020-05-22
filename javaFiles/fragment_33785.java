private void setChannel(NotificationManager nm) {
    int importance = NotificationManager.IMPORTANCE_HIGH;
    if (android.os.Build.VERSION.SDK_INT
            >= android.os.Build.VERSION_CODES.O) {
        if(mChannel == null)
            mChannel = new NotificationChannel(CHANNEL_ID_FOR_OTG, CHANNEL_NAME_FOR_OTG, importance);
        nm.createNotificationChannel(mChannel);
    }
}