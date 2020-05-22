for (final FunctionDataObject fdo : wdo.getFunctionDataList()) {
        JLabel inputTypesLabel = new JLabel("Input Types: ");
        inputsBox.add(inputTypesLabel);
        for (int i = 0; i < fdo.getNumberOfInputs(); i++) {
            final int final_i = i;
            JLabel inputLabel = new JLabel(fdo.getInputNames().get(i));
            final JComboBox inputTypeComboBox = new JComboBox(getTypes());
            inputTypeComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fdo.getInputTypes().set(final_i, (String) inputTypeComboBox.getSelectedItem());
                }
            });
        }
    }