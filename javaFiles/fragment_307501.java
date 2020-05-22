public JPanel createMultiMenu(ArrayList<String> domainItems) {

    checkBoxMenuPanel = new JPanel();
    checkBoxMenuPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.anchor = GridBagConstraints.WEST;


    for (String item : domainItems) {
        JCheckBox checkBox = new JCheckBox(item);
        checkBoxMenuPanel.add(checkBox, gbc);        
    }
    return checkBoxMenuPanel;
}