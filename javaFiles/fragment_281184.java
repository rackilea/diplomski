import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class AutoSumming {

    public static void main(String[] args) {
        new AutoSumming();
    }

    public AutoSumming() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(
                                new String[]{"Amount", "Cost", "Profit"},
                                10) {
                                    @Override
                                    public Object getValueAt(int row, int col) {
                                        Object value = null;
                                        switch (col) {
                                            case 2:
                                                double amount = getAmountForRow(row);
                                                double cost = getCostForRow(row);
                                                value = cost - amount;
                                                break;
                                            default:
                                                value = super.getValueAt(row, col);
                                        }
                                        return value;
                                    }

                                    protected double getAmountForRow(int row) {
                                        return getNumberForRow(row, 0);
                                    }

                                    protected double getCostForRow(int row) {
                                        return getNumberForRow(row, 1);
                                    }

                                    protected double getNumberForRow(int row, int col) {
                                        double number = 0;
                                        Object value = getValueAt(row, col);
                                        if (value != null && value instanceof Number) {
                                            number = ((Number) value).doubleValue();
                                        }
                                        return number;
                                    }

                                    @Override
                                    public void setValueAt(Object aValue, int row, int column) {
                                        if (column != 2) {
                                            if (aValue instanceof Number) {
                                                super.setValueAt(aValue, row, column);
                                                if (column == 0 || column == 1) {
                                                    fireTableCellUpdated(row, 2);
                                                }
                                            }
                                        }
                                    }

                                    @Override
                                    public Class<?> getColumnClass(int columnIndex) {
                                        return Double.class;
                                    }

                                    @Override
                                    public boolean isCellEditable(int row, int column) {
                                        return column != 2;
                                    }

                                };

                JTable table = new JTable(model);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}