Intent acceptIntent = new Intent(ctx, GameReceiver.class);
acceptIntent.setAction(ctx.getString(R.string.broadcast_accept));
acceptIntent.putExtra(ctx.getString(R.string.extra_notification_id),
    notificationId);
acceptIntent.putExtra(ctx.getString(R.string.extra_from_username),
    fromUsername);
PendingIntent acceptPendingIntent = PendingIntent.getBroadcast(ctx, 0,
    acceptIntent, 0);
mBuilder.addAction(R.mipmap.accept, "Accept", acceptPendingIntent)