import java.awt.*;
import java.beans.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableRowColumn2 extends JFrame
{
    private final static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    JTable table;
    DefaultTableModel model;
    JPanel buttonPanel;
    JButton button;

    public TableRowColumn2()
    {
        //  Create table

        Object[][] data =
        {
            {new Integer(1), "A"},
            {new Integer(2), "B"},
            {new Integer(3), "C"}
        };
        String[] columnNames = {"Number","Letter"};
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model)
        {
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }
        };

        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.changeSelection(0, 0, false, false);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        table.getColumnModel().getColumn(0).setCellRenderer( table.getDefaultRenderer(Integer.class) );

        //  Add table and a Button panel to the frame

        final JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane, BorderLayout.CENTER );

        buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.NORTH );

        button = new JButton( "Add Row" );
        button.setMnemonic('A');
        buttonPanel.add( button );
        button.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.addRow( createRow() );
                int row = table.getRowCount() - 1;
                table.changeSelection(row, 0, false, false);
                table.requestFocusInWindow();
            }
        });

    }

    private Object[] createRow()
    {
        Object[] newRow = new Object[2];
        int row = table.getRowCount();
        newRow[0] = Integer.toString(row + 1);
        row = (row % 26) + 1;
        newRow[1] = LETTERS.substring(row-1, row);
        return newRow;
    }

    public static void main(String[] args)
    {
        TableRowColumn2 frame = new TableRowColumn2();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}