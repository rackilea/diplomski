protected static void main(Context context) {
    ArrayList<Channel> channelArrayList = channels();

    for (int i = 0; i < channelArrayList.size(); i++) {
        try {
            Log.i("Channel", "Attempting to create channel: '" + channelArrayList.get(i).getChannel_id() + "'");
            createChannel(context, channelArrayList.get(i));
        } catch (Exception exception) {
            Log.e("Channel", "Attempt to create channel '" +  channelArrayList.get(i).getChannel_id() + "' failed - Exception " + exception);
        }
    }
}

private static void createChannel(Context context, Channel channel) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel notificationChannel = new NotificationChannel(
                  channel.getChannel_id(),
                  channel.getChannel_name(), 
                  channel.getChannel_importance());
        notificationChannel.setDescription(channel.getChannel_description());

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);
    }
}