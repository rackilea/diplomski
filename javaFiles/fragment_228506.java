import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Ex1 extends JPanel{
    private JTextArea textarea = new JTextArea ();
    private JTextField field = new JTextField ();
    private JButton buton = new JButton ("Trimite");

    public Ex1() {
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel (new BorderLayout(2,2));
        JPanel panel2 = new JPanel (new BorderLayout(2,2));

        JLabel label1 = new JLabel ("Mesaje");
        JLabel label2 = new JLabel ("Scrieti un mesaj");

        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(new JScrollPane(textarea), BorderLayout.CENTER);

        panel2.add(label2, BorderLayout.WEST);
        panel2.add(field, BorderLayout.CENTER);
        panel2.add(buton, BorderLayout.EAST);

        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(350, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                JFrame frame = new JFrame("Test");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                Ex1 panel = new Ex1();

                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}