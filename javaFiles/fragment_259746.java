InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getActionMap();
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "a.pressed");
am.put("a.pressed", new AbstractAction() {
    public void actionPerformed(ActionEvent evt) {
        aPress = true;
    }
});