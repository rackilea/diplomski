public void OpenNotification(String key) {
        String keys[] = { key };
        StatusBarNotification sbns[] = getActiveNotifications(keys);
        for (StatusBarNotification sbn : sbns) {
                try {
                        if (sbn == null) {
                                Log.i(TAG, "sbn is null");
                                continue;
                        }
                        Notification n = sbn.getNotification();
                        if (n.contentIntent != null) {
                                PendingIntent pi = n.contentIntent;
                                if (pi != null) {
                                        pi.send();
                                }
                        }
                } catch (Exception e) {
                }
        }
}