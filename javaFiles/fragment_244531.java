public class NullLayout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NullLayout::new);
    }

    NullLayout() {
        JFrame frame = new JFrame("Basket Game");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < 4; i++) {
            JPanel strip = new JPanel();
            strip.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            strip.setBorder(BorderFactory.createTitledBorder("Strip " + i));
            strip.add(new JLabel("Strip " + i));
            mainPanel.add(strip);
        }

        JPanel gamearea = new JPanel();
        gamearea.setLayout(null);
        mainPanel.add(gamearea);

        for (int i = 0; i < 5; i++) {
            int x = i * 100, y = i * 100;
            JPanel basket = new JPanel();
            basket.setSize(200, 50);
            basket.setLocation(x, y);
            basket.setBackground(Color.YELLOW);
            basket.add(new JLabel("x = " + x + ", y = " + y));
            gamearea.add(basket);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(600, 600);

        frame.setVisible(true);
    }
}