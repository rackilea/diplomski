Action showStatusAction = new AbstractAction("Show Status") {
    @Override
    public void actionPerformed(ActionEvent event) {
        boolean selected = (Boolean) getValue(SELECTED_KEY);
        statusBar.setVisible(selected);
    }
};
showStatusAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_W);
showStatusAction.putValue(Action.SELECTED_KEY, true);

showStatusMenuItem = new JCheckBoxMenuItem(showStatusAction);