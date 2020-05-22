import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableSharedHeader extends JPanel
{
    JComboBox comboBox;

    TableSharedHeader()
    {

        JTable table1 = new JTable(5, 3);
        JTable table2 = new JTable(5, 3);
        table2.setTableHeader( table1.getTableHeader() );
        table2.setColumnModel( table1.getColumnModel() );

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout( new BoxLayout(tablePanel, BoxLayout.Y_AXIS) );

        tablePanel.add( new JLabel("First table") );
        tablePanel.add(table1);
        tablePanel.add( new JLabel("Second table") );
        tablePanel.add(table2);

        setLayout( new BorderLayout() );

        JScrollPane scrollPane = new JScrollPane( tablePanel );
        scrollPane.setColumnHeaderView( table1.getTableHeader() );
        add( scrollPane );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("TableSharedHeader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableSharedHeader());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}