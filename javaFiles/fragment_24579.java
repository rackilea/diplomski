/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                MainScreen mainWindow = new MainScreen();
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                mainWindow.frame.setVisible(true);
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}