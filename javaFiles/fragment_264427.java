import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuExample extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenu menu1 = new JMenu("Edit");
    JMenuItem item1 = new JMenuItem("New");
    JMenuItem item2 = new JMenuItem("Open");

    public MenuExample() {
        setJMenuBar(menuBar);
        setVisible(true);
        setSize(400, 200);
        menuBar.add(menu);
        menuBar.add(menu1);
        menu.add(item1);
        menu.add(item2);
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);

            }

        });
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);

            }

        });

    }

    public static void main(String[] args) {
        MenuExample ex = new MenuExample();
    }

}