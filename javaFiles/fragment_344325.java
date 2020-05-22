public class MainFrame extends JFrame {

    public MainFrame() {
        super("Demo frame");
        // set layout
        // add any components 
        add(new Board()); // adding your board component class
        frameOptions();
    }

    private void frameOptions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // or setSize()
        setVisible(true);
    }

    public static void main(String[] a) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                    new MainFrame();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
}