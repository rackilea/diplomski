/*
     * This listener fixes the problem where we would lose selection.
     * Note that it prevents the user from "unselecting" a row.
     */
    public static class GlazedListBug194Listener <T> implements ListSelectionListener {
        private T lastSelectedElement;
        private final JTable table;
        private final AdvancedTableModel<T> model;
        private final AdvancedListSelectionModel<T> select;

        public GlazedListBug194Listener(JTable table, 
                AdvancedTableModel<T> model, 
                AdvancedListSelectionModel<T> select) {
            this.table = table;
            this.model = model;
            this.select = select;

        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());
            if(selectedRow < 0){
                if(table.getRowCount() == 0){
                    //table was cleared
                    lastSelectedElement = null;
                }
                else{
                    //restore selection
                    for(int i = 0; i < table.getRowCount(); i++){
                        if(model.getElementAt(i) == lastSelectedElement){
                            select.setSelectionInterval(i, i);
                            break;
                        }
                    }
                }
            }
            else{
                lastSelectedElement = model.getElementAt(selectedRow);
            }
        }
    }