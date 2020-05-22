import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame t = new JFrame();
                t.setBounds(100, 100, 500, 500);
                t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel global = new JPanel();
                global.setLayout(new MigLayout("wrap 1", "", ""));
                JButton add = new JButton("Add");

                JPanel listItems = new JPanel();
                listItems.setLayout(new MigLayout("wrap 2", "[]20[]", ""));

                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JLabel label = new JLabel("Item Label");
                        JTextField text = new JTextField("Value", 20);
                        listItems.add(label);
                        listItems.add(text);
                        global.validate();
                    }
                });

                global.add(add);
                JScrollPane scroll = new JScrollPane(listItems);
                scroll.setPreferredSize(new Dimension(400, 600));
                global.add(scroll);

                t.add(global);
                t.setVisible(true);
            }
        });
    }
}