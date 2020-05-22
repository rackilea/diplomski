InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getActionMap();

am.put("left", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        label.setText("left");
    }
});
am.put("right", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        label.setText("right");
    }
});
am.put("released", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        label.setText("---");
    }
});