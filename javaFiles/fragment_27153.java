public void defineNotification(String num) {
    new Thread(new Runnable()
    {
        public void run() {
            try {
                Intent i = new Intent(Verify.this, OrderTypes.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);

                notification.setContentTitle("New Order Received")
                notification.setContentText("Train No.12724 \n Amount 500");
                notification.setWhen(System.currentTimeMillis());
                notification.setSmallIcon(R.drawable.omitra_notification_icon);
                notification.addAction(R.drawable.pink_accept, "Accept", pi);
                notification.addAction(R.drawable.pink_decline, "Decline", pi);
                notification.setPriority(Notification.PRIORITY_MAX);

                remote_picture = BitmapFactory.decodeStream((InputStream) new URL(getIntent().getExtras().getString("imageurl")).getContent());
                NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();
                notiStyle.setSummaryText("Amount : 500");
                notiStyle.bigPicture(remote_picture);
                notification.setStyle(notiStyle);

                Intent intent = new Intent(Verify.this, VendorDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("Phone", num);
                PendingIntent pendingIntent = PendingIntent.getActivity(Verify.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                notification.setContentIntent(pendingIntent);
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(uniqueID, notification.build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();
}