import java.awt.Component;
import javax.swing.CellEditor;
import javax.swing.JList;

public interface ListCellEditor<E> extends CellEditor {

    public Component getListCellEditorComponent(
            JList<E> list,
            E value,
            boolean isSelected,
            int index);

    public void applyEditorValue(E value);

}