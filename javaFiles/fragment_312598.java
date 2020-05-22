JTable table = new JTable(model) {

    @Override // Always selectAll()
    public boolean editCellAt(int row, int column, EventObject e) {
        boolean result = super.editCellAt(row, column, e);
        final Component editor = getEditorComponent();
        if (editor == null || !(editor instanceof JTextComponent)) {
            return result;
        }
        if (e instanceof MouseEvent) {
            EventQueue.invokeLater(() -> {
                ((JTextComponent) editor).selectAll();
            });
        } else {
            ((JTextComponent) editor).selectAll();
        }
        return result;
    }
};