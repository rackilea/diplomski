// define two (or more) different icons
Image iconWithNoNotifications = new Image(this.getClass().getResourceAsStream("app_icon.png"));
Image iconWithNotifications = new Image(this.getClass().getResourceAsStream("app_icon_with_notification.png"));

// change the icon when the notifications count changes
primaryStage.getIcons().add(nNotifications == 0 ? iconWithNoNotifications : iconWithNotifications);