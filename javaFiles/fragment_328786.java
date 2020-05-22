import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                String[] colNames = {"Aircraft",
                         "Track ID",
                         "Runway",
                         "Operation Type",
                         "Number Daily of Operations"};
                Object[][] data = {{"Boeing 717",(long) 2459,"01L","Arrival",0.13},{"Boeing 727",(long) 2439,"01R","Arrival",0.12}};

                JTable table = new TranslucentTable();
                DefaultTableModel model = new DefaultTableModel(data, colNames);
                table.setModel(model);

                table.setFont(new Font("Serif", Font.BOLD, 20));
                table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 20));
                table.getTableHeader().setBackground(new Color(0, 0, 0, 100));
                table.getTableHeader().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
                table.getTableHeader().setForeground(Color.WHITE);
                table.setRowHeight(table.getRowHeight() + table.getFont().getSize());
                table.setBackground(new Color(214, 217, 223));
                table.setAutoCreateRowSorter(true);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

                for (int i = 0; i < colNames.length; i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.getContentPane().setBackground(Color.RED);
                TranslucentScrollPane scrollPane = new TranslucentScrollPane();
                scrollPane.setBackground(new Color(0, 0, 0, 200));
                scrollPane.setViewportView(table);

                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}