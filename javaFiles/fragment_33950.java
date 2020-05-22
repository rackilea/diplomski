InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
ActionMap am = table.getActionMap();

KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

im.put(enterKey, "Action.enter");
am.put("Action.enter", new AbstractAction() {
    public void actionPerformed(ActionEvent evt) {
        table.changeSelection(table.getSelectedRow(), 2, false, false);
        if (!table.editCellAt(table.getSelectedRow(), 2)) {
            JOptionPane.showMessageDialog(table, "Failed to start cell editing");
        }
    }
});