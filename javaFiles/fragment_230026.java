import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** @see http://stackoverflow.com/questions/8257148 */
public class SwapTableModel extends JPanel {

    public SwapTableModel() {
        final JTable table = new JTable(Model.Alpha.model);
        table.setPreferredScrollableViewportSize(new Dimension(128, 32));
        this.add(new JScrollPane(table));
        final JComboBox combo = new JComboBox();
        for (Model model : Model.values()) {
            combo.addItem(model);
        }
        this.add(combo);
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Model model = (Model) combo.getSelectedItem();
                table.setModel(model.model);
            }
        });
    }

    private enum Model {

        Alpha(), Beta();
        private DefaultTableModel model;

        private Model() {
            Object[] data = {this.toString()};
            this.model = new DefaultTableModel(data, 1);
            model.addRow(data);
        }
    }

    private void display() {
        JFrame f = new JFrame("SwapTableModel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SwapTableModel().display();
            }
        });
    }
}