import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {

    JLabel logo = new JLabel("MyChef");

    JPanel north = new JPanel();

    public static void main(String args[]) {
        new Menu();
    }

    public Menu() {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("MyChef");
        frame.setResizable(false);

        frame.add(north, BorderLayout.NORTH);
        north.add(logo);

        frame.setSize(500, 300);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }
}