import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class TableCellLineEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    JComboBox combobox;
    private BasicStroke val;
    protected static final String EDIT = "edit";

    public TableCellLineEditor() {

        combobox = new JComboBox(LineStyle.values());
        combobox.setRenderer(new ListCellLineRenderer());
        combobox.setActionCommand(EDIT);
        combobox.addActionListener(this);
    }

    @Override
    public Object getCellEditorValue() {
        return (BasicStroke) ((LineStyle) combobox.getSelectedItem()).getStroke();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        val = (BasicStroke) value;

        for (int i = 0; i < LineStyle.values().length; i++) {
            if (val.equals(((BasicStroke) (LineStyle.values()[i]).getStroke()))) {
                combobox.setSelectedItem(LineStyle.values()[i]);
            }
        }
        return combobox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (EDIT.equals(e.getActionCommand())) {
            val = (BasicStroke) ((LineStyle) combobox.getSelectedItem()).getStroke();
            fireEditingStopped();
        } else {
            val = (BasicStroke) combobox.getSelectedItem();
        }
    }

}