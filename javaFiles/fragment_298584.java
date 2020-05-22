JPanel pnlConditions = new JPanel();
pnlConditions.setLayout(new GridBagLayout());

pnlConditions.add(lblSelections);
pnlConditions.add(txtSelection);
pnlConditions.add(lblInclusions);
pnlConditions.add(txtInclusion);
pnlConditions.add(lblExclusions);
pnlConditions.add(txtExclusion);

for (final Component c : pnlConditions.getComponents()) {      
    if (c instanceof JTextField) {
        ((JTextField) c).setHorizontalAlignment(JTextField.CENTER);
        ...
    }
}