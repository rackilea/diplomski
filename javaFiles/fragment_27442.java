import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApp extends JFrame
{
   private static TrayIcon trayIcon = null;

   public static void main(String[] args) {
      JFrame app = new MyApp();
      app.setSize(400,400);
      app.setVisible(true);

      final Image image = Toolkit.getDefaultToolkit().getImage("MyImage.gif");

      app.addWindowListener( new WindowAdapter() {
         public void windowActivated(WindowEvent ev) {
            registerTrayIcon(image);
         }
      });
   }

   private static void registerTrayIcon(Image image) {
        SystemTray tray = SystemTray.getSystemTray();

        if( trayIcon != null ) {
           tray.remove(trayIcon);
        }

        trayIcon = new TrayIcon(image, "Tray Demo", null);

        try {
           tray.add(trayIcon);
        }
        catch(Exception ex) {
           throw new RuntimeException(ex);
        }
   }
}