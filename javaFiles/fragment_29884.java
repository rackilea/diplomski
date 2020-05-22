// java.awt.* controls are well suited for displaying menu bar icons on OS X
final Image image;
if (isMacMenuBarDarkMode()) {
    image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/tray_icon_darkmode.png"));
} else {
    image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/tray_icon_default.png"));
}