public class ProjectConfigVariableEditingSupport extends EditingSupport {
    private TextCellEditor cellEditor;

    public ProjectConfigVariableEditingSupport(ColumnViewer viewer) {
        super(viewer);
        cellEditor = new TextCellEditor(((TableViewer)viewer).getTable());
    }
    protected CellEditor getCellEditor(Object element) {
        return cellEditor;
    }
    protected boolean canEdit(Object element) {
        return true;
    }
    protected Object getValue(Object element) {
        return ((ProjectDirectory) element).getName();
    }
    @Override
    protected void setValue(Object element, Object value) {
        ((ProjectDirectory) element).setName(String.valueOf(value));
        getViewer().update(element, null);
    }
}