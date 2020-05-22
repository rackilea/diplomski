import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PrecentageCalc extends JFrame {
    private JTextField item2, item4, item5, item7;

    private JButton button, button2;

    public PrecentageCalc() {
        super("Percentage Calculator");
        setLayout(new FlowLayout());

        JLabel item1 = new JLabel("What is");
        add(item1);

        item2 = new JTextField(3);
        add(item2);

        JLabel item3 = new JLabel("% of");
        add(item3);

        item4 = new JTextField(2);
        add(item4);
        button = new JButton("Enter");
        add(button);
        JLabel spacer = new JLabel("                       ");
        add(spacer);

        item5 = new JTextField(3);
        add(item5);

        JLabel item6 = new JLabel("is what % of");
        add(item6);

        item7 = new JTextField(3);
        add(item7);
        button2 = new JButton("Enter");
        add(button2);

        thehandler handler = new thehandler();
        button.addActionListener(handler);
        button2.addActionListener(handler);
    }

    private class thehandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String strx;
            String stry;
            double x, y, answer;
            if (e.getSource() == button) {
                strx = item2.getText();
                stry = item4.getText();
                x = Double.parseDouble(strx);
                y = Double.parseDouble(stry);
                answer = y * 0.01 * x;
                JOptionPane.showMessageDialog(null, answer);
            } else if (e.getSource() == button2) {
                strx = item5.getText();
                stry = item7.getText();
                x = Double.parseDouble(strx);
                y = Double.parseDouble(stry);
                answer = x / y * 100;
                JOptionPane.showMessageDialog(null, answer);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frm = new PrecentageCalc();
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}