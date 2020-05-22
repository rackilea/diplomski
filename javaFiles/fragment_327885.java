// Parent JFrame somewhere
JFrame parent = ....

// Create the dialog content
String str = "Close the external program when done";
Icon i = UIManager.getIcon('OptionPane.informationIcon');
JLabel lb = JLabel(str, i, JLabel.LEFT);
JPanel panel = JPanel();
panel.add(lb);

// Create the dialog window
JDialog dialog = JDialog(parent, "External app", false);  // N.B: NOT modal
dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
dialog.setContentPane(panel); 
dialog.pack(); 
dialog.setVisible(true);  
parent.setEnabled(false);

// start external app
Process p = Runtime.getRuntime().exec("notepad");
p.waitFor();     // wait for it to close

dialog.setVisible(false); 
parent.setEnabled(true);
parent.requestFocus();