import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class TimeSpinner {

    Date date;
    JButton setDate = new JButton("Set Date");
    JButton showSpinner = new JButton("Show Spinner");
    JTextField jtfDate = new JTextField(15);
    JSpinner spinner = new JSpinner();
    JPanel panel;

    public TimeSpinner() {
        jtfDate.setEditable(false);

        panel = new JPanel(new BorderLayout());
        panel.add(setDate, BorderLayout.CENTER);
        panel.add(jtfDate, BorderLayout.NORTH);
        panel.add(showSpinner, BorderLayout.SOUTH);

        setDate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                date = new Date();
                jtfDate.setText(date.toString());
            }
        });
        showSpinner.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (date != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                String dateString = formatter.format(date);
                spinner.setModel(new SpinnerListModel(new String[]{dateString}));
                JOptionPane.showConfirmDialog(null, spinner, "Spinner:"
                        ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        JFrame frame = new JFrame("Date Spinner Demo");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new TimeSpinner();
            }
        });
    }
}