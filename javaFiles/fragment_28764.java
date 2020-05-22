AbstractAction escapeAction = AbstractAction() {
    public void actionPerfomed(ActionEvent e) {
        setText("");
    }
}

textField.addCaretListener(new CaretListener() {
    @Override
    public void caretUpdate(CaretEvent e) {
        if (textField.getText() == null || textField.getText().isEmpty()) {
            textField.getActionMap().remove("escape");
            textField.getInputMap().remove(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        } else {
            textField.getActionMap().put("escape", escapeAction);
            textField.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), escapeAction);
        }
    }
});