import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableSort extends JFrame
{
    JTable table;
    DefaultTableModel model;

    public TableSort()
    {
        Random random = new Random();
        model = new DefaultTableModel(0, 2)
        {
            public Class getColumnClass(int column)
            {
                return Integer.class;
            }
        };

        for (int i = 0; i < 10000; i++)
        {
            Integer[] row = new Integer[2];
            row[0] = random.nextInt(100000);
            row[1] = random.nextInt(100000);
            model.addRow( row );
        }

        table = new JTable( model );
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );
        System.out.println(table.getRowCount());
    }

    public static void main(String[] args)
    {
        TableSort frame = new TableSort();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}