package com.pkg1;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableWithModel extends JFrame {

    private static final long serialVersionUID = 1L;

    // constructor that will display a JTable based on elements received as arguments
    TableWithModel(Object[][] obj, String[] header) {
        super("JTable example");
        JPanel panel = new JPanel(new BorderLayout());

        JTable table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(
                obj, header
                ) 
                {
                    /**
                     * 
                     */
                    private static final long serialVersionUID = 1L;
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, true, true
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {

                        return canEdit [columnIndex];
                    }
                });

        panel.add(new JScrollPane(table));
        add(panel);    // adding panel to frame
        // and display it
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
    }

    // to run the whole thing
    public static void main(String[] args) {
        Object[][] rowAndColumn = {
                {"Dog", "Mammal",Boolean.parseBoolean("true")},
                {"Cat", "Mammal",Boolean.parseBoolean("true")},
                {"Shark", "Fish",Boolean.parseBoolean("false")},
                {"Eagle", "Bird",Boolean.parseBoolean("false")}
        };
        // defines the header
        String[] header = {"Animal", "Family","Domestic"};
        TableWithModel twm = new TableWithModel(rowAndColumn, header);
    }
}