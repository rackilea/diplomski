package app;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Please follow standard naming convention for java classes
public class GUIApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private static JButton attack = new JButton("Attack!");
    private static JButton axe = new JButton("Axe");
    private static JLabel bob = new JLabel("Choose a weapon...");
    private static JButton defend = new JButton("Defend!");
    private static Insets insets = null;
    private static Dimension size = null;
    private static JButton sword = new JButton("Sword");

    public GUIApp() {
        //Notice the layout is null
        setLayout(null);

        //Insets need to be referenced
        insets = getContentPane().getInsets();

        //Layout stuffs
        setTitle("Combat Demo");
        setSize(600,600);
        attack.setSize(100, 50);
        axe.setSize(100, 50);
        defend.setSize(100, 50);
        sword.setSize(100, 50);

        //Toggle visibility
        attack.setVisible(true);
        defend.setVisible(true);
        sword.setVisible(false);
        axe.setVisible(false);
        bob.setVisible(false);

        //Add components
        add(attack);
        add(defend);
        add(sword);
        add(axe);
        add(bob);
    }

    public static void main(String[] args) {
        //Instantiate the object
        GUIApp app = new GUIApp();
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //You could obtain dimension and set bounds in the main method, or anywhere else.
        size = attack.getPreferredSize();
        attack.setBounds(400 + insets.left, 400 + insets.top, size.width, size.height);

        size = defend.getPreferredSize();
        defend.setBounds(100 + insets.left, 400 + insets.top, size.width, size.height);

        //Action listener for attack button
        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                attack.setVisible(false);
                defend.setVisible(false);
                bob.setVisible(true);
                sword.setVisible(true);
                axe.setVisible(true);

                //You could obtain dimension and set bounds in the actionPerformed method.
                size = bob.getPreferredSize();
                bob.setBounds(0 + insets.left, 0 + insets.top, size.width, size.height);

                size = sword.getPreferredSize();
                sword.setBounds(400 + insets.left, 400 + insets.top, size.width, size.height);

                size = axe.getPreferredSize();
                axe.setBounds(100 + insets.left, 400 + insets.top, size.width, size.height);
            }
        });
    }
}