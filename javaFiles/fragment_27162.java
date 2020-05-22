import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class MyCal implements ActionListener {

    JButton jb;
    JTextPane ta5;
    JTextPane ta4;
    JTextPane ta3;
    JTextPane ta2;
    JTextPane ta1;
    JTextPane ta;

    int add = 9, mul, div, sub, num, num1;

    MyCal ()

    {
        JFrame jf = new JFrame();

        jb = new JButton("Calculate");
        jb.setBounds(80, 145, 100, 40);
        jb.addActionListener(this);

        this.ta = new JTextPane();
        ta.setBounds(80, 30, 100, 40);

        // ta.setText("First Number");

        this.ta1 = new JTextPane();
        ta1.setBounds(80, 100, 100, 40);

        // ta1.setText("Second Number");

        this.ta2 = new JTextPane();
        ta2.setText("Addition");
        ta2.setBounds(10, 200, 50, 30);

        this.ta3 = new JTextPane();
        ta3.setText("Subtraction");
        ta3.setBounds(70, 200, 50, 30);

        this.ta4 = new JTextPane();
        ta4.setText("Multiplication");
        ta4.setBounds(130, 200, 50, 30);

        this.ta5 = new JTextPane();
        ta5.setText("Division");
        ta5.setBounds(190, 200, 50, 30);

        jf.add(ta);
        jf.add(ta1);
        jf.add(jb);
        jf.add(ta2);
        jf.add(ta3);
        jf.add(ta4);
        jf.add(ta5);

        jf.setSize(300, 300);
        jf.setLayout(null);
        jf.setVisible(true);

    }

    public static void main(String[] args) {

        new MyCal();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ta3.setText("Hello");
    }

}