import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Q2 extends JFrame {

    JTextField t;
    JComboBox combobox;
    JButton b;

    public Q2() {
        combobox = new JComboBox();
        t = new JTextField("Enter text here", 20);
        t.setEditable(true);
        b = new JButton("Add");
        b.addActionListener(new act()); //Add ActionListener to button instead.
        add(t);
        add(combobox);
        add(b);

        //combobox.addItem(t.getText().toString()); //Moved to ActionListener.
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class act implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            combobox.addItem(t.getText()); //Removed .toString() because it returns a string.
        }
    }

    public static void main(String[] args) {
        Q2 test = new Q2();
    }
}