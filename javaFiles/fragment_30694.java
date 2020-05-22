GridBagConstraints constraints = new GridBagConstraints();
constraints.fill = GridBagConstraints.BOTH;
constraints.gridx = 0;
constraints.gridy = 0;
constraints.weightx = 1;
constraints.weighty = 1;
depictorPanel.add(currentViewer, constraints);
depictorPanel.revalidate();