public class MainWindow extends JFrame {

    private static MainWindow instance;

    public static MainWindow getMainWindow() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }

    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
        initComponents();
    }

    private void initComponents() {
        // ... skip original code for brevity ...
    }
}