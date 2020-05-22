@SuppressWarnings("serial")
class IntroPanel extends JPanel {
    private Temp2 temp2;

    public IntroPanel(Temp2 temp2) {
        this.temp2 = temp2;
        setLayout(new GridBagLayout());
        add(new JButton(new GoToBattleAction("Go To Battle", KeyEvent.VK_G)));
    }

    private class GoToBattleAction extends AbstractAction {
        public GoToBattleAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            temp2.showCard(GamePanel.class.getName());
        }
    }

}