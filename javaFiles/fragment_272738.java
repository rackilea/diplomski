public void setDefaultEditor(Class<?> columnClass, TableCellEditor editor) {
    if (editor != null) {
        defaultEditorsByColumnClass.put(columnClass, editor);
    }
    else {
        defaultEditorsByColumnClass.remove(columnClass);
    }
}