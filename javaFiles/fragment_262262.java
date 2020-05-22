public class SystemTrayTest {

  public static void main(String[] args) {
    new SystemTrayTest();
  }

  public SystemTrayTest() {
    if (SystemTray.isSupported()) {

      EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          } catch (Exception ex) {
          }
          try {
            TrayIcon trayIcon = new TrayIcon(ImageIO.read(SystemTrayTest.class.getResource("/battery_green.png")), "Feel the power");
            MouseHandler mouseHandler = new MouseHandler();
            trayIcon.addMouseMotionListener(mouseHandler);
            trayIcon.addMouseListener(mouseHandler);
            SystemTray.getSystemTray().add(trayIcon);
          } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
          }
        }
      });
    }
  }

  public class MouseHandler extends MouseAdapter {

    private Timer popupTimer;
    private JWindow popup;
    private Point point;

    public MouseHandler() {
      popup = new JWindow();
      ((JComponent)popup.getContentPane()).setBorder(new LineBorder(Color.LIGHT_GRAY));
      popup.setLayout(new GridLayout(0, 1));
      popup.add(new JLabel("Charging (45%)", JLabel.CENTER));

      try {
        popup.add(new JLabel("Charging", new ImageIcon(ImageIO.read(getClass().getResource("/battery_connection.png"))), JLabel.LEFT));
        popup.add(new JLabel("Power Saver", new ImageIcon(ImageIO.read(getClass().getResource("/flash_yellow.png"))), JLabel.LEFT));
      } catch (IOException exp) {
        exp.printStackTrace();
      }
      popup.pack();

      popupTimer = new Timer(250, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (point != null) {
            System.out.println(point);
            Rectangle bounds = getScreenViewableBounds(point);
            int x = point.x;
            int y = point.y;
            if (y < bounds.y) {
              y = bounds.y;
            } else if (y > bounds.y + bounds.height) {
              y = bounds.y + bounds.height;
            }
            if (x < bounds.x) {
              x = bounds.x;
            } else if (x > bounds.x + bounds.width) {
              x = bounds.x + bounds.width;
            }

            if (x + popup.getWidth() > bounds.x + bounds.width) {
              x = (bounds.x + bounds.width) - popup.getWidth();
            }
            if (y + popup.getWidth() > bounds.y + bounds.height) {
              y = (bounds.y + bounds.height) - popup.getHeight();
            }
            popup.setLocation(x, y);
            popup.setVisible(true);
          }
        }
      });
      popupTimer.setRepeats(false);

    }

    @Override
    public void mouseExited(MouseEvent e) {
      System.out.println("Stop");
      point = null;
      popupTimer.stop();
      popup.setVisible(false);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      popupTimer.restart();
      point = e.getPoint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      System.exit(0);
    }
  }

  public static GraphicsDevice getGraphicsDeviceAt(Point pos) {

    GraphicsDevice device = null;

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice lstGDs[] = ge.getScreenDevices();

    ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);

    for (GraphicsDevice gd : lstGDs) {

      GraphicsConfiguration gc = gd.getDefaultConfiguration();
      Rectangle screenBounds = gc.getBounds();

      if (screenBounds.contains(pos)) {

        lstDevices.add(gd);

      }

    }

    if (lstDevices.size() == 1) {

      device = lstDevices.get(0);

    }

    return device;

  }

  public static Rectangle getScreenViewableBounds(Point p) {

    return getScreenViewableBounds(getGraphicsDeviceAt(p));

  }

  public static Rectangle getScreenViewableBounds(GraphicsDevice gd) {

    Rectangle bounds = new Rectangle(0, 0, 0, 0);

    if (gd != null) {

      GraphicsConfiguration gc = gd.getDefaultConfiguration();
      bounds = gc.getBounds();

      Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

      bounds.x += insets.left;
      bounds.y += insets.top;
      bounds.width -= (insets.left + insets.right);
      bounds.height -= (insets.top + insets.bottom);

    }

    return bounds;

  }
}