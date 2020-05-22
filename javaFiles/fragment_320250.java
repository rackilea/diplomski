JButton bAddRow = new JButton("Add Row");
    bAddRow.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent evt) {
        ((PSRBTableModel)table.getModel()).addRow(
            new Object[] { new PanelSpinnerRadioButtonData(false, 10, 40) }
        );
        table.updateUI();
      }
    });