private void BigTextNotificationForDays(Context context, String Message, String Author) {
            Intent resultIntent = new Intent(context, SplashActivity.class);
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) Calendar.getInstance().getTimeInMillis(), resultIntent, PendingIntent.FLAG_ONE_SHOT);

            //To set large icon in notification
            //  Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.big_image);

            //Assign inbox style notification
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
            bigText.bigText(Message);
            bigText.setBigContentTitle(context.getString(R.string.app_name));
            bigText.setSummaryText(Author);
            //build notification
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,createNotificationChannel(context))
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle(context.getString(R.string.app_name))
                    .setContentText(Message)
                    .setStyle(bigText)
                    .setLargeIcon(icon)
                    .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                    .setVibrate(new long[]{1000, 1000})
                    .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent);
            //.setOngoing(true);

            // Gets an instance of the LocalNotificationManager service
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            //to post your notification to the notification bar
            mNotificationManager.notify(3730, mBuilder.build()); // (int) System.currentTimeMillis() set instead of id. if at a time more notification require
        }


public static String createNotificationChannel(Context context) {

        // NotificationChannels are required for Notifications on O (API 26) and above.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // The id of the channel.
            String channelId = "Channel_id";

            // The user-visible name of the channel.
            CharSequence channelName = "Application_name";
            // The user-visible description of the channel.
            String channelDescription = "Application_name Alert";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            boolean channelEnableVibrate = true;
//            int channelLockscreenVisibility = Notification.;

            // Initializes NotificationChannel.
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.enableVibration(channelEnableVibrate);
//            notificationChannel.setLockscreenVisibility(channelLockscreenVisibility);

            // Adds NotificationChannel to system. Attempting to create an existing notification
            // channel with its original values performs no operation, so it's safe to perform the
            // below sequence.
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);

            return channelId;
        } else {
            // Returns null for pre-O (26) devices.
            return null;
        }
    }