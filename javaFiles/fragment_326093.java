import java.awt.Component;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TableWithProgressBars {

    private static final int maximum = 100;

    public void createGUI() {
        final JFrame frame = new JFrame("Progressing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Integer[] oneRow = {0, 0, 0, 0};
        String[] headers = {"One", "Two", "Three", "Four"};
        Integer[][] data = {oneRow, oneRow, oneRow, oneRow, oneRow,};
        final DefaultTableModel model = new DefaultTableModel(data, headers);
        final JTable table = new JTable(model);
        table.setDefaultRenderer(Object.class, new ProgressRenderer(0, maximum));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                Object waiter = new Object();
                synchronized (waiter) {
                    int rows = model.getRowCount();
                    int columns = model.getColumnCount();
                    Random random = new Random(System.currentTimeMillis());
                    boolean done = false;
                    while (!done) {
                        int row = random.nextInt(rows);
                        int column = random.nextInt(columns);
                        Integer value = (Integer) model.getValueAt(row, column);
                        value++;
                        if (value <= maximum) {
                            model.setValueAt(value, row, column);
                            try {
                                waiter.wait(15);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        done = true;
                        for (row = 0; row < rows; row++) {
                            for (column = 0; column < columns; column++) {
                                if (!model.getValueAt(row, column).equals(maximum)) {
                                    done = false;
                                    break;
                                }
                            }
                            if (!done) {
                                break;
                            }
                        }
                    }
                    frame.setTitle("All work done");
                }
            }
        }).start();
    }

    public static class ProgressRenderer extends JProgressBar implements TableCellRenderer {

        private static final long serialVersionUID = 1L;

        public ProgressRenderer(int min, int max) {
            super(min, max);
            this.setStringPainted(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            this.setValue((Integer) value);
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TableWithProgressBars().createGUI();
            }
        });

    }
}