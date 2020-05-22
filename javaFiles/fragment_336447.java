tree.getCellEditor().addCellEditorListener(new CellEditorListener() {

        @Override
        public void editingStopped(ChangeEvent e) {
            System.out.println(((DefaultCellEditor)e.getSource()).getCellEditorValue());
        }

        @Override
        public void editingCanceled(ChangeEvent e) {
             System.out.println(((DefaultCellEditor)e.getSource()).getCellEditorValue());
        }
    });