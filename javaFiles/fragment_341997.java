AutoCompleteDecorator.decorate( withEditor );
ComboBoxCellEditor editor = new ComboBoxCellEditor(withEditor);
CellEditorListener listener = new CellEditorListener() {

    @Override
    public void editingStopped(ChangeEvent e) {
        // do commit stuff
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
    }
};
editor.addCellEditorListener(listener);
contentPane.add(withEditor, BorderLayout.SOUTH);