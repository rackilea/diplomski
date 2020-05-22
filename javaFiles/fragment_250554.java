if (SystemTray.isSupported()) {
    popupMenu = createPopupMenu();
    SystemTray systemTray = SystemTray.getSystemTray();
    Image img = Toolkit.getDefaultToolkit().getImage("image.gif");
    trayIcon = new TrayIcon(img);
    trayIcon.setImageAutoSize(true);
    systemTray.add(trayIcon);
    trayIcon.addMouseListener(new SystemTrayMouseListener());