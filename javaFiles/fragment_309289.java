import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class check1 extends JFrame implements ActionListener {

    JEditorPane jep;
    JScrollPane scroll;
    JPanel p, p1;
    JButton b1, b2;
    String url;

    public check1() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        b1 = new JButton("Button 1");
        b1.addActionListener(this);
        b2 = new JButton("Button 2");
        b2.addActionListener(this);

        p = new JPanel();
        p.setLayout(new FlowLayout());

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2, 1, 1));
        p1.add(b1);
        p1.add(b2);

        try {
            jep = new JEditorPane(
                    new URL("http://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html#constructor.summary"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scroll = new JScrollPane(jep);
        setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(p1, BorderLayout.WEST);
        getContentPane().add(scroll, BorderLayout.CENTER);

        setSize(1000, 800);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        new check1().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            url = "http://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html#constructor.summary";
        } else if (e.getSource().equals(b2)) {
            url = "http://docs.oracle.com/javase/8/docs/api/javax/swing/JApplet.html#constructor.summary";
        }
        try {
            jep.setPage(new URL(url));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}