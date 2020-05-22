public class Example extends JFrame {

    Example() {

        JPanel playScreen = new JPanel();
        playScreen.setLayout(new BorderLayout());

        JPanel towerButtons = new JPanel();
        towerButtons.add(new JLabel("towerButtons"));
        playScreen.add(towerButtons, BorderLayout.EAST);

        JPanel detailPanel = new JPanel();
        detailPanel.add(new JLabel("detailPanel"));
        playScreen.add(detailPanel, BorderLayout.WEST);

        playScreen.add(new JButton("hello"), BorderLayout.CENTER);

        add(playScreen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {

        new Example();
    }
}