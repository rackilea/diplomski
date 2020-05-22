public class Panel_Test extends JFrame {
    public Panel_Test() {
        // code here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Panel_Test();
            }
        });
    }
}