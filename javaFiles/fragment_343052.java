private PendingIntent getPendingIntent(Context context) {
        int requestCode = 69;
        return PendingIntent.getBroadcast(context, requestCode,
                new Intent(mContext, AlarmReceiver.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
    }