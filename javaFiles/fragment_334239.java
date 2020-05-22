public class JavaApplication13 {

    public static void main(String[] args) {
        // All swing applications must run on their own thread.
        SwingUtilities.invokeLater(() -> {
            DBP prozor = new DBP();
            prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            prozor.setVisible(true);
        });

    }

}

class DBP extends JFrame {
    private JLabel oznaka;
    private boolean upgraded; //whether user upgraded

    public DBP() {
        setTitle("Cookie Clicker");
        setSize(500, 150);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        oznaka = new JLabel("No points!");
        add(oznaka);
        JButton dugme = new JButton("Click");
        add(dugme);

        JButton upgrade = new JButton("Buy upgrade!");
        add(upgrade);
        upgrade.setVisible(false);

        dugme.addActionListener(new ActionListener() {
            private int brojac;

            @Override
            public void actionPerformed(ActionEvent e) {

                brojac++;
                if (upgraded)
                    brojac++;
                oznaka.setText("Points " + brojac);
                if (brojac == 5) {
                    upgrade.setVisible(true);

                }

            }
        });

        upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgrade.setVisible(false);
                upgraded = true;
            }
        });
    }
}