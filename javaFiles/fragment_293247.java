import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableExample {

    public static void main(String[] args) {
        new TableExample();
    }

    public TableExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                List<String> visibleColumns = new ArrayList<String>();
                visibleColumns.add("Column 1");
                visibleColumns.add("Column 2");
                visibleColumns.add("Column 3");

                DefaultTableModel tableModel = new DefaultTableModel(visibleColumns.toArray(), 100);
                JTable table = new JTable(tableModel);

                JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JPanel left = new JPanel();
                left.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                scroll.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, left);

                JPanel right = new JPanel();
                right.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                scroll.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, right);

                JPanel columnHeader = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        JScrollBar sb = new JScrollBar(JScrollBar.VERTICAL);
                        return new Dimension(sb.getPreferredSize().width, 10);
                    }
                };
                columnHeader.setBorder(new CompoundBorder(
                        new MatteBorder(1, 1, 0, 0, Color.WHITE),
                        new MatteBorder(0, 0, 1, 1, Color.GRAY)
                ));
                scroll.setRowHeaderView(columnHeader);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(scroll);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}