private JPanel myPanel;

public JPanel getMyPanel() {
    if (myPanel == null) {
        myPanel = new JPanel(this);
    }
    return myPanel;
}