public class MyFrame extends JFrame {
    public MyFrame() {
        initComponents();
        jPanel1 = new GraphicsClass();
    }

    private void initComponent() {
        jPanel1 = new JPanel();
        // add jPanel1 to frame
    }

    private class GraphicsClass extends JPanel {}

    private JPanel jpanel1;
}