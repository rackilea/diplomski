import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPLocationFinder {
    public static void main(String[] args) {
        final String[] columns = { "IP address", "Country" };
        final String[][] data = {};
        final DefaultTableModel model = new DefaultTableModel(data, columns);
        final JTable jt = new JTable(model);
        final JFrame frame = new JFrame();
        final JScrollPane jps = new JScrollPane(jt);
        final JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        JButton b1 = new JButton("Start");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);

        panel.add(b1, c);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(jps, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.addRow(new String[] { "Column 1", "Country 1" });
            }
        };
        b1.addActionListener(actionListener);

        frame.pack();
        frame.setVisible(true);
    }
}