private void mapKey(String keyStroke, final String command) {
    Action action = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            close(command);
        }
    };
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(keyStroke), action);
    getRootPane().getActionMap()
        .put(action, action);
}