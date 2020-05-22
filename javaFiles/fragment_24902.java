public JPanel createPanel() {
    JPanel panel = new JPanel();
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    panel.setLayout(gb);
    okButton = new JButton("Ok");
    cancellButton = new JButton("Cancel");
    idTF = new JTextField(10);
    nameTf = new JTextField(10);
    idlbl = new JLabel("ID");
    namelbl = new JLabel("Name");
    add(panel, idlbl, 0, 0, 1, 1, gb, gbc, false);
    add(panel, idTF, 0, 1, 1, 1, gb, gbc, true);
    add(panel, namelbl, 1, 0, 1, 1, gb, gbc, false);
    add(panel, nameTf, 1, 1, 1, 1, gb, gbc, true);
    add(panel, okButton, 2, 0, 1, 1, gb, gbc, false);
    add(panel, cancellButton, 2, 1, 1, 1, gb, gbc, true);
    return panel;
}

private void add(Container outer, Component c, int x, int y, int w, int h, GridBagLayout gb, GridBagConstraints gbc, boolean wide) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = w;
    gbc.gridheight = h;
    if (wide) {
        gbc.weightx = 100;
    } else {
        gbc.weightx = 0;
    }
    gb.setConstraints(c, gbc);
    outer.add(c);
}