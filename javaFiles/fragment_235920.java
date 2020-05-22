Intent msgIntent = new Intent(this, ExampleClass.class);

        PendingIntent nManagerStart = PendingIntent.getActivity(this, 0,
                msgIntent, 0);

        msg.flags |= (Notification.FLAG_AUTO_CANCEL);

msg.setLatestEventInfo(this, contentTitle, contentText, nManagerStart);

        notificationManager.notify(NOTIFY_ID, msg);