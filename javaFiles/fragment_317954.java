import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class TableSortSSCCE extends JPanel
{
    private String[] columnNames = {"First Name",
                                    "Last Name",
                                    "Sport",
                                    "# of Years",
                                    "Vegetarian"};

    private Object[][] data =
    {
        {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
    };

    private JTable table;


    public TableSortSSCCE()
    {
        super(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize( table.getPreferredSize() );
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton clear = new JButton("Clear Table");
        clear.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
            }
        });
        add(clear, BorderLayout.NORTH);


        JButton reload = new JButton("Reload Table");
        reload.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TableRowSorter sorter = (TableRowSorter)table.getRowSorter();
                List<? extends RowSorter.SortKey> sortKeys = sorter.getSortKeys();

                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                table.setModel(model);
                table.setAutoCreateRowSorter( true );

                sorter = (TableRowSorter)table.getRowSorter();
                sorter.setSortKeys( sortKeys );
            }
        });
        add(reload, BorderLayout.SOUTH);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("TableSortSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableSortSSCCE newContentPane = new TableSortSSCCE();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}