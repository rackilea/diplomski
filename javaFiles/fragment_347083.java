Action saveAction = new AbstractAction("Save") {
    @Override
    public void actionPerformed(ActionEvent event) {
        saveDocument();
    }
};
saveAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));

saveMenuItem = new JMenuItem(saveAction);