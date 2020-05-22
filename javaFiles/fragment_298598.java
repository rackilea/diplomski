private void onAction(String actionStr) {
    Action action = table.getActionMap().get(actionStr);
    ActionEvent newAE = new ActionEvent(table, ActionEvent.ACTION_PERFOMED, actionStr);
    action.actionPerfomed(newAE);
}

private void decorateButtons() {
    copyButton.addActionListener(new ActionListener() {
        public void actionPerfomed(ActionEvent ae) {
            onAction("copy");
        }
    });
    cutButton.addActionListener(new ActionListener() {
        public void actionPerfomed(ActionEvent ae) {
            onAction("cut");
        }
    });
    pasteButton.addActionListener(new ActionListener() {
        public void actionPerfomed(ActionEvent ae) {
            onAction("paste");
        }
    });
}