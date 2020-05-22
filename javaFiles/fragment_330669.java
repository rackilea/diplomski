public void actionPerformed(ActionEvent e) {
  // assuming this is being called from within a JFrame named myFrame
  JDialog dialog = new JDialog(myFrame, "Dialog Title", ModalityType.APPLICATION_MODAL);
  dialog.getContentPane().add(interface);
  dialog.pack();
  dialog.setLocationRelativeTo(myFrame);
  dialog.setVisible(true);
}