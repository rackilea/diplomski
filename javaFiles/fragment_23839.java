// Class LeftPanel:
class LeftPanel extends JPanel {
    private JPanel leftPanel;
    private JComboBox<String> comboBox; //!!

    // !!
    public LeftPanel(String[] comboTexts) {
        leftPanel = new JPanel();
        comboBox = new JComboBox<>(comboTexts); // !!
        leftPanel.add(comboBox);
        add(leftPanel);
    }

    // !!
    public String getComboSelection() {
        return comboBox.getSelectedItem().toString();
    }

    // !!
    public void comboAddActionListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }
}