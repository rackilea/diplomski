import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class ProgTypesTable {

    static private DefaultTableModel modelProgTypes;
    static private JTable table;
    static private JInternalFrame internal;
    static private JScrollPane scrollPane;

    static JInternalFrame table() {
        final String[] headings = new String[]{"ID", "Рубрики:"};
        modelProgTypes = new DefaultTableModel(headings, 0);
        for (int index = 0; index < 26; index++) {
            modelProgTypes.addRow(new Object[]{((char)'A' + index) + "-1", ((char)'A' + index) + "-1"});
        }
        table = new JTable(modelProgTypes);

        JButton jbAddProgType = new JButton("Добавить рубрику");
        JButton jbDelProgType = new JButton(" Удалить рубрику ");
        JButton jbEditProgType = new JButton("Изменить рубрику");

//      table.removeColumn(table.getColumnModel().getColumn(0));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 18));
        table.getColumnModel().getColumn(0).setPreferredWidth(120);

        internal = new JInternalFrame("Рубрики", true, true, false, true);
        internal.setLayout(new BorderLayout());
        internal.setVisible(true);

        scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        buttons.add(jbAddProgType, gbc);
        buttons.add(jbEditProgType, gbc);
        buttons.add(jbDelProgType, gbc);

        internal.getContentPane().add(scrollPane);
        internal.getContentPane().add(buttons, BorderLayout.EAST);
        internal.pack();
        return internal;
    }

    public static void main(String[] args) {
        new ProgTypesTable();
    }

    public ProgTypesTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JDesktopPane dp = new JDesktopPane();
                dp.add(table());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dp);
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}