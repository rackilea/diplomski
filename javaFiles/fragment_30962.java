import javax.swing.*;
import javax.swing.table.*;

public class TestTable {
    private static Object[][] data = new Object[][] {
            { "a", "b", "c" },
            { "d", "e", "f" }
    };
    private static Object[] colNames = new Object[] { "1", "2", "3" };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTable table = new JTable(data, colNames)
                {
                    @Override
                    public boolean getScrollableTracksViewportWidth()
                    {
                        return getPreferredSize().width < getParent().getWidth();
                    }

                    @Override
                    public void doLayout()
                    {
                        TableColumn resizingColumn = null;

                        if (tableHeader != null)
                            resizingColumn = tableHeader.getResizingColumn();

                        //  Viewport size changed. May need to increase columns widths

                        if (resizingColumn == null)
                        {
                            setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                            super.doLayout();
                        }

                        //  Specific column resized. Reset preferred widths

                        else
                        {
                            TableColumnModel tcm = getColumnModel();

                            for (int i = 0; i < tcm.getColumnCount(); i++)
                            {
                                TableColumn tc = tcm.getColumn(i);
                                tc.setPreferredWidth( tc.getWidth() );
                            }

                            // Columns don't fill the viewport, invoke default layout

                            if (tcm.getTotalColumnWidth() < getParent().getWidth())
                                setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                                super.doLayout();
                        }

                        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    }

                };
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}