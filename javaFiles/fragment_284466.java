@SuppressWarnings("serial")
class GamePanel extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 350;
    public static final int DAMAGE_AMOUNT = 100;
    private Temp2 temp2;
    private Player2 player2 = new Player2();
    private JLabel statusLabel = new JLabel();

    public GamePanel(Temp2 temp2) {
        this.temp2 = temp2;
        player2.addPropertyChangeListener(Player2.HEALTH, new PlayerListener());

        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
        statusPanel.add(new JLabel("Health"));
        statusPanel.add(statusLabel);
        displayHealth();

        JPanel battlePanel = new JPanel(new GridBagLayout());
        battlePanel.add(new JButton(new BattleAction("Battle", KeyEvent.VK_B)));

        setLayout(new BorderLayout());
        add(statusPanel, BorderLayout.PAGE_START);
        add(battlePanel, BorderLayout.CENTER);
    }

    private void displayHealth() {
        String healthText = String.format("%03d/%03d", player2.getHealth(), Player2.MAX_HEALTH);
        statusLabel.setText(healthText);
    }

    public void reset() {
        player2.setHealth(Player2.MAX_HEALTH);
        temp2.showCard(IntroPanel.class.getName());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class BattleAction extends AbstractAction {
        public BattleAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int health = player2.getHealth() - DAMAGE_AMOUNT;
            player2.setHealth(health);
        }
    }

    private class PlayerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            int health = (int) evt.getNewValue();
            displayHealth();
            if (health <= 0) {
                reset();
            }
        }
    }

}