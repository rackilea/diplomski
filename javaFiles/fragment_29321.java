int okCxl = JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor(this),
                                    textArea,
                                    "Enter Data",
                                    JOptionPane.OK_CANCEL_OPTION)

if (okCxl == JOptionPane.OK_OPTION) {
  String text = textArea.getText();
  // Process text.
}