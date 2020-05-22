import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GreedyKnapsack {

    private JPanel panel;
    private JFrame frame;
    private DefaultTableModel model;
    private JTable table;
    private String col[] = { "item", "profit", "weight", "  Take weight" };
    private double[] profit;
    private double[] weight;
    private double[] take;

    public GreedyKnapsack(final int n) {
        profit = new double[n];
        weight = new double[n];
        take = new double[n];
        for (int i = 0; i < n; i++) {
            profit[i] = (int) Math.round(Math.random() * 100);
            weight[i] = (int) Math.round(Math.random() * 100);
        }
    }

    public void unitPriceOrder() {
        for (int i = 0; i < profit.length; i++) {
            for (int j = 1; j < (profit.length - i); j++) {
                double x = profit[j - 1] / weight[j - 1];
                double y = profit[j] / weight[j];
                if (x <= y) {
                    double temp = profit[j - 1];
                    profit[j - 1] = profit[j];
                    profit[j] = temp;
                    double temp1 = weight[j - 1];
                    weight[j - 1] = weight[j];
                    weight[j] = temp1;
                }
            }
        }
    }

    public void Knapsack(final int m) {
        unitPriceOrder();
        int j;
        for (j = 0; j < profit.length; j++) {
            take[j] = 0;
        }
        double total = m;
        for (j = 0; j < profit.length; j++) {
            if (weight[j] <= total) {
                take[j] = 1.00;
                total = total - weight[j];
            } else {
                break;
            }
        }
        if (j < profit.length) {
            take[j] = total / weight[j];
        }
    }

    public void displayTable(final int x) {
        this.model = new DefaultTableModel(col, x);
        this.table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        for (int i = 0; i < x; i++) {
            table.setValueAt(i, i, 0);
            table.setValueAt(profit[i], i, 1);
            table.setValueAt(weight[i], i, 2);
            table.setValueAt(take[i], i, 3);
        }
        panel = new JPanel();
        panel.add(pane);
        frame = new JFrame();
        frame.setSize(500, 400);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String args[]) {
        int items = Integer.parseInt(JOptionPane.showInputDialog("Enter number of items"));
        GreedyKnapsack greedyKnapsack = new GreedyKnapsack(items);
        int packSize = Integer.parseInt(JOptionPane.showInputDialog("Please enter bag size"));
        greedyKnapsack.Knapsack(packSize);
        greedyKnapsack.displayTable(items);
    }

}