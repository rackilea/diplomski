import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JList;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EditableList<E> extends JList<E> {

    private ListCellEditor<E> editor;
    private int editingCell = -1;
    private Component editorComponent;

    private CellEditorHandler handler;

    public EditableList(MutableListModel<E> model) {
        this();
        setModel(model);
    }

    public EditableList() {
        InputMap im = getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "editorCell");

        ActionMap am = getActionMap();
        am.put("editorCell", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit baby");
                int cell = getSelectedIndex();
                editCellAt(cell);
            }
        });

        addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (isEditing()) {

                    if (!stopCellEditing()) {

                        cancelCellEditing();

                    }

                }
            }
        });
    }

    public boolean isEditing() {

        return editorComponent != null;

    }

    public void cancelCellEditing() {

        getEditor().cancelCellEditing();

    }

    public boolean stopCellEditing() {

        return getEditor().stopCellEditing();

    }

    public CellEditorHandler getCellEditorHandler() {
        if (handler == null) {
            handler = new CellEditorHandler();
        }
        return handler;
    }

    public void setEditor(ListCellEditor<E> value) {
        if (value != editor) {
            ListCellEditor old = editor;
            editor = value;
            firePropertyChange("editor", old, editor);
        }
    }

    public ListCellEditor<E> getEditor() {
        return editor;
    }

    public boolean isCellEditable(int cell) {

        boolean isEditable = false;

        ListModel model = getModel();
        if (model instanceof MutableListModel) {

            MutableListModel mcm = (MutableListModel) model;
            isEditable = mcm.isCellEditable(cell);

        }

        return isEditable;

    }

    protected void editCellAt(int index) {

        if (isCellEditable(index)) {

            ListCellEditor<E> editor = getEditor();
            if (editor != null) {

                Rectangle cellBounds = getCellBounds(index, index);
                E value = getModel().getElementAt(index);
                boolean selected = isSelectedIndex(index);
                editingCell = index;

                editor.addCellEditorListener(getCellEditorHandler());
                editorComponent = editor.getListCellEditorComponent(this, value, selected, index);
                editorComponent.setBounds(cellBounds);

                ensureIndexIsVisible(index);

                add(editorComponent);

                revalidate();

            }

        }

    }

    public int getEditingCell() {
        return editingCell;
    }

    protected void editingHasStopped(ListCellEditor editor) {

        editingCell = -1;

        if (editorComponent != null) {
            remove(editorComponent);
        }

        if (editor != null) {

            editor.removeCellEditorListener(getCellEditorHandler());

        }

    }

    public class CellEditorHandler implements CellEditorListener {

        @Override
        public void editingStopped(ChangeEvent e) {

            E value = getModel().getElementAt(getEditingCell());

            getEditor().applyEditorValue(value);
            ((MutableListModel) getModel()).setElementAt(value, getEditingCell());

            editingHasStopped((ListCellEditor)e.getSource());

        }

        @Override
        public void editingCanceled(ChangeEvent e) {

            editingHasStopped((ListCellEditor)e.getSource());

        }

    }

}