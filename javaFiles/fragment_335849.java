import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.table.*;

public class SSCCE extends JPanel
{
    SSCCE()
    {
        JTable table = new JTable( getTableModel() );
        JScrollPane scrollPane = new JScrollPane( table );

        setLayout( new BorderLayout() );
        add(scrollPane, BorderLayout.CENTER);
    }

    private TableModel getTableModel()
    {
        DefaultTableModel model = new DefaultTableModel(5, 3);

        return model;
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
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