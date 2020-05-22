class CardExampleMain {
    private JPanel mainPanel = new JPanel();
    private CardUser cardUser = new CardUser();
    private Card1 card1 = new Card1(cardUser);
    private Card2 card2 = new Card2(cardUser);
    private Card3 card3 = new Card3(cardUser);
    private JComboBox<String> cardKeyBox;

    public CardExampleMain() {
        cardUser.addCard(card1, card1.getName());
        cardUser.addCard(card2, card2.getName());
        cardUser.addCard(card3, card3.getName());

        int itemsSize = cardUser.getKeys().size();
        String[] items = cardUser.getKeys().toArray(new String[itemsSize]);
        cardKeyBox = new JComboBox<>(items);
        cardKeyBox.setSelectedIndex(-1);
        cardKeyBox.addActionListener(e -> cardUser.show(cardKeyBox.getSelectedItem().toString()));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEtchedBorder());
        topPanel.add(new JLabel("Select Card:"));
        topPanel.add(cardKeyBox);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(cardUser.getMainPanel());
        mainPanel.add(topPanel, BorderLayout.PAGE_START);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}