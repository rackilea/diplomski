public class MainWindow extends JFrame {

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        GlassPane gp = new GlassPane();
        setContentPane(gp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}