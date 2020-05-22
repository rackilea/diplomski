GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.insets = new Insets(10, 10, 5, 10);
    constraints.anchor = GridBagConstraints.WEST;

    Set<Object> keys = configProps.keySet();
    for (Object k : keys) {
        JLabel label = new JLabel(k.toString());
        JTextField field = new JTextField(configProps.getProperty(k.toString()), 10);

        constraints.gridx = 0;
        add(label, constraints);
        constraints.gridx++;
        add(field, constraints);
        constraints.gridy++;
    }
    constraints.gridx = 0;
    constraints.gridwidth = 2;
    constraints.anchor = GridBagConstraints.CENTER;
    add(buttonSave, constraints);