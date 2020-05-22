import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Proj extends JFrame implements ActionListener {

    Proj() {
        JMenuBar rodMenu = new JMenuBar();
        JMenu menu = new JMenu("Vis");
        JMenuItem men_item1 = new JMenuItem("Statestik");

        JPanel wrapper = new JPanel();
        wrapper.setPreferredSize(new Dimension(380, 240));
        wrapper.setBorder(BorderFactory.createLineBorder(Color.black));

        setJMenuBar(rodMenu);
        rodMenu.add(menu);
        menu.add(men_item1);

        JButton b = new JButton("Test");
        wrapper.add(b);

        add(wrapper);

        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Proj();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}