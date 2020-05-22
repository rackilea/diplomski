// Class RightPanel:
class RightPanel extends JPanel {
    private JPanel rightPanel;
    private RP1Panel rightPanel1;
    private RP2Panel rightPanel2;
    private CardLayout cardLayout;

    public RightPanel() {
        rightPanel = new JPanel();
        rightPanel1 = new RP1Panel();
        rightPanel2 = new RP2Panel();
        cardLayout = new CardLayout();
        rightPanel.setLayout(cardLayout);
        rightPanel.add(rightPanel1, RP1Panel.NAME); //!!
        rightPanel.add(rightPanel2, RP2Panel.NAME);  // !!
        cardLayout.show(rightPanel, RP1Panel.NAME); // !!
        add(rightPanel);
    }

    // !! 
    public void showCard(String name) {
        cardLayout.show(rightPanel, name);
    }
}