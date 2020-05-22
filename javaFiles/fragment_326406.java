public class MainWindow extends JFrame {

    private static final long serialVersionUID = -9170930657273608379L;

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.go();
    }

    private void go() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JButton button = new JButton("Click me");

        button.addActionListener(new ActionListener() {

            private Window2 ww = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ww==null) {
                    ww = new Window2(); //creating the new window here
                    ww.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    ww.setTitle("Window2 created on " + new Date());
                    ww.setSize(500, 200);
                }

                pack();
                ww.setVisible(true);
            }
        });

        setLayout(new BorderLayout());
        add(button);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
    }
}