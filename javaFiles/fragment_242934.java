InputMap im = getInputMap(WHEN_FOCUSED);
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
ActionMap am = getActionMap();
am.put("enter", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowCount = table.getSelectedRow() + 1;
        tModel.insertRow(rowCount,new Object[]{"", "","",""});                 
        table.setRowSelectionInterval(rowCount, rowCount);
    }
});