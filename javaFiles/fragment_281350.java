NotificationManager notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
Notification notif = new Notification(icon, mess, when);

Intent notifIntent = new Intent(context, Activity.class);

notifIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
        | Intent.FLAG_ACTIVITY_SINGLE_TOP);

PendingIntent intent = PendingIntent.getActivity(context, 0, notifIntent, 0);

notif.setLatestEventInfo(context, title, mess, intent);
notif.flags |= Notification.FLAG_AUTO_CANCEL;
notifManager.notify(0, notif);