final JLabel label = new JLabel("Text shall change with shortcut");
final KeyStroke key = KeyStroke.getKeyStroke((Character)'k',
        InputEvent.CTRL_DOWN_MASK, false);
final Object actionKey = "auml";
final Action action = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("aha");
        label.setText("It is working!!!");
    }
};
label.addKeyListener(new KeyAdapter() {

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.isControlDown() && e.getKeyChar() == 'ä') {
            System.out.println("Ctrl-ä");
            label.getActionMap().get(actionKey).actionPerformed(null);
            // return;
        }
        super.keyPressed(e);
    }
});
label.getInputMap().put(key, actionKey);
label.getActionMap().put(actionKey, action);