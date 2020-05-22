public class MyFrame extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    public MyFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.black);

        JPanel panel = new JPanel();
        panel.setBackground(Color.red);

        getContentPane().add(panel);

        pack();
    }
}