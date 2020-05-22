public class UsageExample extends JPanel {

    public UsageExample() {
        super(new BorderLayout());
        OvalImageLabel l;
        try {
            l = new OvalImageLabel(new File("/path/to/image.png").toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        add(l, BorderLayout.CENTER);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setContentPane(new UsageExample());
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}