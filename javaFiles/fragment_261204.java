import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MyFrame() {
        final JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout(10, 10));

        final JPanel childPanel1 = new JPanel();
        childPanel1.setBackground(Color.red);
        childPanel1.setPreferredSize(new Dimension(300, 40));

        final JPanel childPanel2 = new JPanel();
        childPanel2.setBackground(Color.blue);
        childPanel2.setPreferredSize(new Dimension(800, 600));

        JButton myButton = new JButton("Add Component ");
        myButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                parentPanel.remove(childPanel1);
                parentPanel.add(childPanel2, BorderLayout.CENTER);
                parentPanel.revalidate();
                parentPanel.repaint();
                pack();
            }
        });
        setTitle("My Empty Frame");
        setLocation(10, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentPanel.add(childPanel1, BorderLayout.CENTER);
        parentPanel.add(myButton, BorderLayout.SOUTH);
        add(parentPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyFrame myFrame = new MyFrame();
            }
        });
    }
}