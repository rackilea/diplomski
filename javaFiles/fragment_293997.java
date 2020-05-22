KeyStroke keyStroke = KeyStroke.getKeyStroke("TAB");
Object actionKey = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .get(keyStroke );
final Action action = table.getActionMap().get(actionKey);
Action wrapper = new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = (JTable) e.getSource();
        int lastRow = table.getRowCount() - 1;
        int lastColumn = table.getColumnCount() -1;
        if (table.getSelectionModel().getLeadSelectionIndex() == lastRow 
                && table.getColumnModel().getSelectionModel()
                        .getLeadSelectionIndex() == lastColumn) {
              return;
        }
        action.actionPerformed(e);
    }

};
table.getActionMap().put(actionKey, wrapper);