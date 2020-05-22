testate.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridy = 0;
gbc.insets = new Insets(4, 4, 4, 4);
gbc.anchor = GridBagConstraints.WEST;
for (String testata : listaTestate) {
    gbc.gridx = 0;
    JCheckBox checkbox = new JCheckBox();
    ImageIcon imgTestata = new ImageIcon(getClass().getResource("/img/"+testata+".png"));
    checkbox.setName(testata);
    checkbox.setBackground(new Color(194, 169, 221));
    checkbox.setSelected(true);
    testate.add(checkbox, gbc);
    gbc.gridx++;
    JLabel label = new JLabel(imgTestata);
    label.setBackground(new Color(194, 169, 221));
    testate.add(label, gbc);
    gbc.gridy++;
}