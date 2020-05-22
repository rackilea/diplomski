final JPanel panel2 = new JPanel();
    panel2.setLayout(new GridBagLayout());
    panel2.setBackground(Color.WHITE);

    final GridBagConstraints cons = new GridBagConstraints();
    cons.weightx = 1D;
    cons.weighty = 1D;
    cons.anchor = GridBagConstraints.NORTHWEST;
    panel2.add(box, cons);

    tabbedPane.addTab("Balance", panel2);