Object [] options1 = {"Go Back", "Accept"};
JOptionPane jop = new JOptionPane("Mean arterial pressure restored.\nReassess all vitals STAT.", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options1, options1[0]);
JDialog dialog = jop.createDialog(null, "Title");
dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
// In real code, you should invoke this from AWT-EventQueue using invokeAndWait() or something
dialog.setVisible(true);
// and would cast in a safe manner
String a3 = (String) jop.getValue();
if (a3.equals("Accept")) {

} else if (a3.equals("Go Back")) {

}
// don't forget to dispose of the dialog
dialog.dispose();