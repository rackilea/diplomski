final JCheckBox check1 = new JCheckBox("Check1");
final JCheckBox check2 = new JCheckBox("Check2");
final JCheckBox check3 = new JCheckBox("Check3");

final JButton buttonToBeEnabled = new JButton("Submit");
buttonToBeEnabled.setEnabled(false);

ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean enable = check1.isSelected() && check3.isSelected();
        buttonToBeEnabled.setEnabled(enable);
    }
};

check1.addActionListener(actionListener);
check2.addActionListener(actionListener);
check3.addActionListener(actionListener);