import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ImageIconTable
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageIconTable().initGUI();
            }
        });
    }

    public void initGUI()
    {
        JFrame frame = new JFrame();        
        DefaultTableModel tableModel = new DefaultTableModel()
        {
            @Override
            public Class getColumnClass(int column)
            {
                if (column == 1) return ImageIcon.class; 
                return Object.class;
            }
        };
        tableModel.addColumn("Row 1");
        tableModel.addColumn("Icons Row");
        tableModel.addRow(new Object[]{"This cell is an Object", new ImageIcon("icon.jpg")});
        _table = new JTable(tableModel);

        updateRowHeights();

        frame.add(new JScrollPane(_table), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateRowHeights()
    {
        try
        {
            for (int row = 0; row < _table.getRowCount(); row++)
            {
                int rowHeight = _table.getRowHeight();

                for (int column = 0; column < _table.getColumnCount(); column++)
                {
                    Component comp = _table.prepareRenderer(_table.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                _table.setRowHeight(row, rowHeight);
            }
        }
        catch(ClassCastException e) {}
    }

    private JTable _table;
}