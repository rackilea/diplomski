TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE); 

EditingSupport editingSupport = new EditingSupport(viewer) 
{
    ... implement abstract methods ...

    protected boolean canEdit(Object element)
    {
        return (/* criteria to determine if this column is editable*/)
    } 
}; 

column.setEditingSupport(editingSupport);