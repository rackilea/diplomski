import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

public class ResultGUI extends JFrame
{
    public ResultGUI()
    {
        String[] columnNames = {"points"};
        Object[][] data =
        {{ new Long(1)}, { new Long(2)},{ new Long(9) },{ new Long(4)}
        };

        final JTable table = new JTable(data, columnNames)
        {

            public Class getColumnClass(int column)
            {
                // Lookup first non-null data on column
                for (int row = 0; row < getRowCount(); row++) 
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setAutoCreateRowSorter(true);
        // DefaultRowSorter has the sort() method
        DefaultRowSorter sorter = ((DefaultRowSorter)table.getRowSorter()); 
        ArrayList list = new ArrayList();
        list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
        sorter.setSortKeys(list);
        sorter.sort();
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    public static void main(String[] args)
    {
        ResultGUI frame = new ResultGUI();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}