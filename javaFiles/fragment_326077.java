public class Test {
    private static JFrame mainFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new JFrame("test");
                mainFrame.setSize(800,600);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setVisible(true);

                A a = new A();
            }
        });
    }

    public static class A extends JDialog {

        public A() {
            super(mainFrame);
            setAlwaysOnTop(true);
            setFocusableWindowState(false);
            setSize(80,60);
            setVisible(true);

            mainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    A.this.setAlwaysOnTop(true);
                    A.this.toFront();
                }
                @Override
                public void windowDeactivated(WindowEvent e) {
                    A.this.setAlwaysOnTop(false);
                }
            });
        }
    }
}