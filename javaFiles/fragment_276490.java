import javax.swing.*;
import javax.swing.table.*;

public class Test2Table
{
    private static Object[][] data = new Object[][]
    {
            { "a", "b", "c" },
            { "d", "e", "f" }
    };
    private static Object[] colNames = new Object[] { "1", "2", "3" };

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                JTable table = new JTable(data, colNames)
                {
                    @Override
                    public void doLayout()
                    {
                        //  Viewport size changed. Change last column width

                        if (tableHeader != null
                        &&  tableHeader.getResizingColumn() == null)
                        {
                            TableColumnModel tcm = getColumnModel();
                            int delta = getParent().getWidth() - tcm.getTotalColumnWidth();
                            TableColumn last = tcm.getColumn(tcm.getColumnCount() - 1);
                            last.setPreferredWidth(last.getPreferredWidth() + delta);
                            last.setWidth(last.getPreferredWidth());
                        }
                        else
                        {
                            super.doLayout();
                        }
                    }

                };

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}