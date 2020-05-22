// Class ParentPanel:
class ParentPanel extends JPanel {
    private JPanel ParentPanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;

    public ParentPanel() {
        ParentPanel = new JPanel();
        leftPanel = new LeftPanel(new String[] {RP1Panel.NAME, RP2Panel.NAME});
        rightPanel = new RightPanel();
        ParentPanel.setLayout(new GridLayout(1, 2));
        ParentPanel.add(leftPanel);
        ParentPanel.add(rightPanel);
        add(ParentPanel);

        // !!
        leftPanel.comboAddActionListener(e -> {
            String selection = leftPanel.getComboSelection();
            rightPanel.showCard(selection);
        });
    }
}