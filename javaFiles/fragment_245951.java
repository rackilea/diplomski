public class ProjectConfigPathEditingSupport extends EditingSupport{
    private DialogCellEditor  cellEditor;

    //Pass selecProjectPathText of the bigger composite to brose from that directory
    public ProjectConfigPathEditingSupport(ColumnViewer viewer, Text selectProjectPathText) {
        super(viewer);
        cellEditor = new DialogCellEditor(((TableViewer)viewer).getTable()) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                // TODO Auto-generated method stub
                DirectoryDialog dialog = new DirectoryDialog(cellEditorWindow.getShell());
                dialog.setText("Browse");
                dialog.setFilterPath(selectProjectPathText.getText()); // Windows specific
                return  dialog.open();
            }
        };
    }
    protected CellEditor getCellEditor(Object element) {
        return cellEditor;
    }
    protected boolean canEdit(Object element) {
        return true;
    }
    protected Object getValue(Object element) {
        return ((ProjectDirectory) element).getPath();
    }
    protected void setValue(Object element, Object value) 
    {
        ((ProjectDirectory) element).setPath(String.valueOf(value));
        getViewer().update(element, null);
    }
}