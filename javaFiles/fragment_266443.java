import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class CopyTable {

    public static void main(String[] args) {
        new CopyTable();
    }

    public CopyTable() {
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

        private JTable table;
        private JTextField customer;
        private JSpinner date;

        public TestPane() {

            DefaultTableModel model = new DefaultTableModel();
            for (int index = 0; index < 26; index++) {
                model.addColumn((char) (index + 65));
            }

            for (int row = 0; row < 26; row++) {
                Vector rowData = new Vector();
                for (int col = 0; col < 26; col++) {
                    rowData.add(row + "x" + col);
                }
                model.addRow(rowData);
            }

            table = new JTable(model);

            Calendar calendar = Calendar.getInstance();
            Date initDate = calendar.getTime();
            Date earliestDate = calendar.getTime();
            calendar.add(Calendar.YEAR, 200);
            Date latestDate = calendar.getTime();
            SpinnerModel spinnerModel = new SpinnerDateModel(
                            initDate,
                            earliestDate,
                            latestDate,
                            Calendar.YEAR);

            date = new JSpinner();
            date.setModel(spinnerModel);
            date.setEditor(new JSpinner.DateEditor(date, "dd/MM/yyyy"));

            customer = new JTextField(10);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            add(new JLabel("Customer:"), gbc);
            gbc.gridy++;
            add(new JLabel("Date:"), gbc);

            gbc.gridy = 0;
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(customer, gbc);
            gbc.gridy++;
            add(date, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(table), gbc);
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            JButton print = new JButton("Print");
            add(print, gbc);

            print.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    MessageFormat header = new MessageFormat("Customer: " + customer.getText() + " | Date: " + new SimpleDateFormat("dd/MM/yyyy").format(date.getValue()));
                    try {
                        table.print(JTable.PrintMode.FIT_WIDTH, header, null, true, null, true);
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        }

    }
}