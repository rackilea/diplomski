import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class Testing {

    public static JTable table;
    public static JButton button;
    public static JTextField field1, field2, field3, field4;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {}

        DefaultTableModel model = new DefaultTableModel(new String[]{"Column1", "Column2", "Column3", "Column4"}, 0);
        JTable table = new JTable(model);

        JFrame frame = new JFrame();
        frame.setTitle("Testing");
        frame.setSize(700, 500);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());

        JSplitPane split = new JSplitPane();
        frame.add(split, BorderLayout.CENTER);

        split.setLeftComponent(new JScrollPane(table));

        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        split.setRightComponent(menu);

        button = new JButton("Button");
        field1 = new JTextField();
        field1.setEnabled(false);
        bindFieldToTableColumn(field1, table, 0);

        field2 = new JTextField();
        field2.setEnabled(false);
        bindFieldToTableColumn(field2, table, 1);

        field3 = new JTextField();
        field3.setEnabled(false);
        bindFieldToTableColumn(field3, table, 2);

        field4 = new JTextField();
        field4.setEnabled(false);
        bindFieldToTableColumn(field4, table, 3);

        GridBagConstraints gbc = new GridBagConstraints();
        Insets margin = new Insets(2, 4, 2, 4);
        gbc.insets = margin;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        menu.add(button, gbc); 

        gbc.gridy = 1;
        menu.add(field1, gbc);

        gbc.gridy = 2;
        menu.add(field2, gbc);

        gbc.gridy = 3;
        menu.add(field3, gbc);

        gbc.gridy = 4;
        menu.add(field4, gbc);

        gbc.weighty = 1;
        gbc.gridy = 5;
        menu.add(new JPanel(), gbc);

        frame.setVisible(true);

        // Populate table to demonstrate.
        Random r = new Random();
        for(int i=0; i<5; i++) {
            model.addRow(new Object[]{r.nextInt(99999-10000)+10000,"username"+r.nextInt(100), (char)r.nextInt(255), (char)r.nextInt(255)});
        }

        // To change column header text you would do this.
        changeColumnName(table, 0, "ID");
        changeColumnName(table, 1, "Username");
        changeColumnName(table, 2, "Blahblah");
        changeColumnName(table, 3, "Blahblah Blah");
    }

    public static void changeColumnName(JTable table, int column, String name) {
        table.getColumnModel().getColumn(column).setHeaderValue(name);
    }

    public static void bindFieldToTableColumn(final JTextField field, final JTable table, final int column) {
        ListSelectionModel lsm = table.getSelectionModel();
        field.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent arg0) {
                onUpdate(arg0);
            }
            public void insertUpdate(DocumentEvent arg0) {
                onUpdate(arg0);
            }
            public void removeUpdate(DocumentEvent arg0) {
                onUpdate(arg0);
            }
            public void onUpdate(DocumentEvent e) {
                if(!table.hasFocus() && field.hasFocus()) {
                    table.setValueAt(field.getText(), table.getSelectedRow(), column);
                }
            }
        });
        table.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int col = e.getColumn();
                if(!field.hasFocus() && col == column) {
                    field.setText(table.getValueAt(row, col).toString());
                }
            }
        });
        lsm.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                int selected = table.getSelectedRow();
                if(selected == -1) {
                    field.setEnabled(false);
                } else {
                    field.setEnabled(true);
                    Object val = table.getValueAt(table.getSelectedRow(), column);
                    if(val != null) {
                        field.setText(val.toString());
                    } else {
                        field.setText("");
                    }
                }
            }
        });
    }
}