import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class RefreshSSCCE extends JPanel
{
    private JTable table = new JTable();
    private int columns = 3;

    public RefreshSSCCE()
    {
        setLayout( new BorderLayout() );

        JButton refresh = new JButton( "Refresh Data" );
        add(refresh, BorderLayout.NORTH);

        refresh.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                refreshData();
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void refreshData()
    {
        DefaultTableModel model = new DefaultTableModel(5, columns++);
        table.setModel( model );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Refresh SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new RefreshSSCCE() );
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