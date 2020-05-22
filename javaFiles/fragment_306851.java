public class DiceGame {

    private JPanel centerPanel = new JPanel();
    private Random rand = new Random();
    private int numDice = 2;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new DiceGame());
    }

    public DiceGame() {

        JFrame gameFrame = new JFrame();
        gameFrame.setSize(800, 600);
        gameFrame.setTitle("Dice Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton buttonW1 = new JButton("Add Die");
        buttonW1.addActionListener(e -> {
            numDice++;
            updateCenterPanel();
        });
        JPanel panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelWest.setBackground(new Color(0, 0, 122));
        panelWest.add(Box.createVerticalGlue());
        panelWest.add(buttonW1);
        panelWest.add(Box.createVerticalGlue());

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setBackground(new Color(0, 122, 0));

        mainPanel.add(panelWest, BorderLayout.WEST);
        mainPanel.add(centerPanel);

        gameFrame.add(mainPanel);
        gameFrame.setVisible(true);
    }

    private void updateCenterPanel() {

        centerPanel.removeAll();
        centerPanel.add(Box.createHorizontalGlue());

        JButton[] diceArray = new JButton[numDice];

        for (int i = 0; i < numDice; i++) {
            diceArray[i] = new JButton(Integer.toString(rand.nextInt(6) + 1));
            diceArray[i].setName("Dice" + i);
            diceArray[i].addActionListener(e -> {
                numDice--;
                updateCenterPanel();
            });
            centerPanel.add(diceArray[i]);
            centerPanel.add(Box.createHorizontalGlue());
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}