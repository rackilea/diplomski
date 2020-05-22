String title = "Congratulations sir";
    String message = "You've successfully created your first Tray Notification";

    Notification notification = Notifications.SUCCESS;
    TrayNotification tray = new TrayNotification(title, message, notification);
    tray.showAndWait();