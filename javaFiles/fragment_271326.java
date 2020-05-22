package cf.pgmann.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Calculation_ActionEvent extends JFrame implements ActionListener {
    JFrame f;
    JLabel l;
    JTextField tf1, tf3;
    JButton b1, b2, b3, b4, b5, b6;

    Calculation_ActionEvent(String s) {
        f = new JFrame(s);
        f.setLayout(null);
        l = new JLabel("Enter two numbers : ");
        tf1 = new JTextField();
        // tf2 = new JTextField();
        tf3 = new JTextField();
        b1 = new JButton("+");
        b2 = new JButton("-");
        b3 = new JButton("*");
        b4 = new JButton("/");
        b5 = new JButton("equals");
        b6 = new JButton("C");
        f.add(l);
        f.add(tf1);
        f.add(tf3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        tf1.setBounds(160, 100, 250, 30);
        // tf2.setBounds(320,100,50,30);
        tf3.setBounds(250, 420, 50, 30);
        b1.setBounds(250, 180, 50, 30);
        b2.setBounds(350, 260, 50, 30);
        b3.setBounds(150, 260, 50, 30);
        b4.setBounds(250, 340, 50, 30);
        b5.setBounds(230, 260, 90, 30);
        b6.setBounds(420, 100, 50, 30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        f.setSize(550, 550);
        f.setVisible(true);
    }

    int total = 0;
    String lastAction = "";

    public void actionPerformed(ActionEvent e) {
        int num = 0;
        try {
            num = Integer.parseInt(tf1.getText());
        } catch(NumberFormatException ex) {}
        String s1 = e.getActionCommand();
        if (s1.equals("C")) {
            tf1.setText("");
            tf3.setText("0");
            tf1.requestFocus();
            total = 0;
        } else if (s1.equals("equals")) {
            tf3.setText(String.valueOf(calc(total, lastAction, num)));
            tf1.setText("");
            tf1.requestFocus();
            total = 0;
        } else {
            total = total==0 ? num : calc(total, lastAction, num);
            tf3.setText(String.valueOf(total));
            tf1.setText("");
            tf1.requestFocus();
            lastAction = s1;
        }
    }

    private int calc(int num1, String action, int num2) {
        switch (action) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
        case "/":
            return num1 / num2;
        default:
            return num1;
        }
    }

    public static void main(String... s) {
        new Calculation_ActionEvent("Calculator");
    }
}