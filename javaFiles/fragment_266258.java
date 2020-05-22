import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class TableCopyEditor extends JPanel
{
    public TableCopyEditor()
    {
        String[] columnNames = {"Editable", "Non Editable"};
        Object[][] data =
        {
            {"1", "one"},
            {"2", "two"},
            {"3", "three"}
        };

        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

        //  Create a non-editable editor, but still allow text selection

        Caret caret = new DefaultCaret()
        {
            public void focusGained(FocusEvent e)
            {
                setVisible(true);
                setSelectionVisible(true);
            }
        };
        caret.setBlinkRate( UIManager.getInt("TextField.caretBlinkRate") );

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setCaret(caret);
        textField.setBorder(new LineBorder(Color.BLACK));

        DefaultCellEditor dce = new DefaultCellEditor( textField );
        table.getColumnModel().getColumn(1).setCellEditor(dce);
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Table Copy Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TableCopyEditor() );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }

}