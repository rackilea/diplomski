import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
//import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
//import javax.swing.text.*;
//import java.beans.*;
import javax.swing.border.*;
//import javax.swing.plaf.*;
//import javax.swing.text.*;
import javax.swing.table.*;
//import java.io.*;
//import javax.imageio.*;
//import java.awt.geom.*;

public class SSCCE extends JPanel
{
    private JTable table;

    public SSCCE()
    {
        setLayout( new BorderLayout() );

        JComboBox<Integer> comboBox = new JComboBox<Integer>();
        comboBox.addItem( new Integer(10) );
        comboBox.addItem( new Integer(20) );
        comboBox.addItem( new Integer(30) );
        comboBox.addItem( new Integer(40) );

        comboBox.addItemListener( new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                Integer value = (Integer)comboBox.getSelectedItem();
                newFilter( value );
            }
        });
        add(comboBox, BorderLayout.NORTH);

        table = new JTable(40, 3);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void newFilter(int numberOfRows)
    {
        final RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>()
        {
            @Override
            public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry)
            {
                int i = table.convertRowIndexToView(entry.getIdentifier());

                //System.out.println(i + " : " + numberOfRows + " : " + entry.getIdentifier());

                return i < numberOfRows;
            }

        };

        ((TableRowSorter) table.getRowSorter()).setRowFilter(null);

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                ((TableRowSorter) table.getRowSorter()).setRowFilter(filter);
            }
        });

    }

    private static void createAndShowGUI()
    {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}