//Creating CommandListeners, which take the reference to targetEnvironmentComboBox (null)
//Although targetEnvironmentComboBox is later set to a usable value, the local copies still
//have the null reference which is assigned here
commandOptionsComboBox.addActionListener(new CommandListener());
executeButton = new JButton("Execute");
executeButton.addActionListener(new CommandListener());

//initializing targetEnvironmentComboBox, which is still null (the first time at least)
targetEnvironmentComboBox = new JComboBox(targetEnvironments.toArray());