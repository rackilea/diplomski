import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            DefaultTableModel model = new DefaultTableModel(1, 1);
            model.setValueAt(0, 0, 0);
            JTable table = new JTable(model);
            table.getColumnModel().getColumn(0).setCellRenderer(new ProgressTableCellRenderer());
            add(new JScrollPane(table));

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Integer value = (Integer)table.getValueAt(0, 0);
                    value++;
                    if (value > 100) {
                        value = 100;
                        ((Timer)e.getSource()).stop();
                    }
                    System.out.println(value);
                    table.setValueAt(value, 0, 0);
                }
            });
            timer.start();
        }

    }

    public class ProgressTableCellRenderer extends JPanel implements TableCellRenderer {

        private int progressValue;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Integer) {
                progressValue = (Integer)value;
            }
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(UIManager.getColor("List.selectionBackground"));
            int x = (int) (getWidth() * (progressValue / 100d));
            g2d.fillRect(0, 0, x, getHeight());
            g2d.dispose();
        }


    }

}