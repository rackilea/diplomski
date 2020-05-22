private void SetTextColorActionPerformed(java.awt.event.ActionEvent evt) {                                             
    Color color = JColorChooser.showDialog(this, "Colors",Color.BLUE);
    StyledDocument doc = textPane.getStyledDocument();
    int from = textPane.getSelectionStart();
    int to = textPane.getSelectionEnd();
    Style style = textPane.addStyle("I'm a Style", null);
    StyleConstants.setForeground(style, color);
    doc.setCharacterAttributes(from, to-from, style, true);
}