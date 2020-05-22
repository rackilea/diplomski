@SuppressWarnings("serial")
abstract class CardPanel extends JPanel {
    private static final int EB_GAP = 5;
    protected CardUser cardUser;
    protected Action nextAction;
    protected Action previousAction;
    protected Action showAction;

    public CardPanel(CardUser cardUser) {
        this.cardUser = cardUser;

        nextAction = new CardAction("Next", KeyEvent.VK_N, e -> cardUser.next());
        previousAction = new CardAction("Previous", KeyEvent.VK_P, e -> cardUser.previous());

        setBorder(BorderFactory.createEmptyBorder(EB_GAP, EB_GAP, EB_GAP, EB_GAP));
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(new JButton(previousAction));
        buttonPanel.add(new JButton(nextAction));

        add(buttonPanel, BorderLayout.PAGE_END);

    }
}