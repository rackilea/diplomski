PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), Player.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP), PendingIntent.FLAG_UPDATE_CURRENT);
notification = new Notification();
notification.tickerText = "App Name";
notification.icon = R.drawable.icon;
notification.flags |= Notification.FLAG_ONGOING_EVENT;
try {
        notification.setLatestEventInfo(getApplicationContext(), "App Name", "AppName~ ", pi);
} catch (Exception e) {

        e.printStackTrace();
}
startForeground(01, notification);