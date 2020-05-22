public class SystemTrayTest {

  public static void main(String[] args) {
    if (SystemTray.isSupported()) {

      EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          } catch (Exception ex) {
          }
          try {
            final JPopupMenu popup = new JPopupMenu();
            popup.add(new JLabel("Charging (45%)", JLabel.CENTER));

            popup.add(new JLabel("Charging", new ImageIcon(ImageIO.read(SystemTrayTest.class.getResource("/battery_connection.png"))), JLabel.LEFT));
            popup.add(new JLabel("Power Saver", new ImageIcon(ImageIO.read(SystemTrayTest.class.getResource("/flash_yellow.png"))), JLabel.LEFT));

            popup.add(new JSeparator());

            JMenuItem exitMI = new JMenuItem("Exit");
            exitMI.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                System.exit(0);
              }
            });
            popup.add(exitMI);

            TrayIcon trayIcon = new TrayIcon(ImageIO.read(SystemTrayTest.class.getResource("/battery_green.png")), "Feel the power");
            trayIcon.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                popup.setLocation(e.getX(), e.getY());
                popup.setInvoker(popup);
                popup.setVisible(true);
              }
            });
            SystemTray.getSystemTray().add(trayIcon);
          } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
          }

        }
      });
    }

  }
}