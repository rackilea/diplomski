final PopupMenu popup = new PopupMenu();
    final TrayIcon trayIcon =
            new TrayIcon(createImage("images/bulb.gif", "tray icon"));
    final SystemTray tray = SystemTray.getSystemTray();

    // Populate popup menu

    trayIcon.setPopupMenu(popup);

    try {
        tray.add(trayIcon);
    } catch (AWTException e) {
        System.out.println("TrayIcon could not be added.");
    }