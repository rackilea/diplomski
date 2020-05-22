private class RowListener implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            for (int c : table.getSelectedRows()) {
                int row = table.convertRowIndexToModel(c);
                TableModel model = table.getModel();
                for (int col = 0; col < model.getRowCount(); col++) {
                    System.out.println(model.getValueAt(row, col));
                }
                System.out.println();
            }
        }
    }
}