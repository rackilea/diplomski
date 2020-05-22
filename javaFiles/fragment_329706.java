class CardUser {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private List<String> keys = new ArrayList<>();

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addCard(Component component, String key) {
        mainPanel.add(component, key);
        keys.add(key);
    }

    public void show(String key) {
        cardLayout.show(mainPanel, key);
    }

    public void next() {
        cardLayout.next(mainPanel);
    }

    public void previous() {
        cardLayout.previous(mainPanel);
    }

    public List<String> getKeys() {
        return keys;
    }
}