private void WordWrapActionPerformed(java.awt.event.ActionEvent evt) {
    AbstractButton button = (AbstractButton) evt.getSource();
    if (button.isSelected()) {
        textArea.setLineWrap(true);
    } else {
        textArea.setLineWrap(false);
    }
    textArea.revalidate();
}