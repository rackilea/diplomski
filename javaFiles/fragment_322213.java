JOptionPane optionPane = new JOptionPane();
optionPane.setMessage("Fubars Rule!");
optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
recursiveUnfocusButtons(optionPane);
JDialog dialog = optionPane.createDialog(null, "Option Title");
dialog.setVisible(true); 
System.exit(0);