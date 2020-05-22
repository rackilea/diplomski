this.setLayout(mainLayout);
mainCons.gridy = 1;
mainCons.gridx = 1;
mainCons.anchor = GridBagConstraints.NORTHWEST;
mainCons.weightx = 1;
this.add(createNorthPanel(), mainCons);

mainCons.anchor = GridBagConstraints.WEST;
mainCons.weightx = 1;
mainCons.gridy = 2;
mainCons.gridx = 1;
mainCons.insets = new Insets(15, 0, 0, 0);
this.add(createCenterPanel(), mainCons);

mainCons.anchor = GridBagConstraints.SOUTHWEST;
mainCons.weightx = 1;
mainCons.gridy = 3;
mainCons.gridx = 1;
this.add(createSouthPanel(), mainCons);