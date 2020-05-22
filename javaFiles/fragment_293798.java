import javax.swing.ListModel;

public interface MutableListModel<E> extends ListModel<E> {

    public void setElementAt(E value, int index);

    public boolean isCellEditable(int index);

}