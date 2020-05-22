package sample;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

public class OptionEditingSupport extends EditingSupport 
{
    private ComboBoxCellEditor cellEditor;

    public OptionEditingSupport(ColumnViewer viewer) {
        super(viewer);
        cellEditor = new ComboBoxCellEditor(((TableViewer)viewer).getTable(), new String[]{"Y", "N"});
    }
    protected CellEditor getCellEditor(Object element) {
        return cellEditor;
    }
    protected boolean canEdit(Object element) {
        return true;
    }
    protected Object getValue(Object element) {
        return 0;
    }
    protected void setValue(Object element, Object value) 
    {
        if((element instanceof Person) && (value instanceof Integer)) {
            Integer choice = (Integer)value;
            String option = (choice == 0? "Y":"N");
            ((Person)element).setLikes( option );
            getViewer().update(element, null);
        }
    }
}