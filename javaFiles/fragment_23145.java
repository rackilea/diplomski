import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Grid {

    public Grid(){
          execute();
    }

    public void execute(){
        JFrame frame = new JFrame("GridBag");
        frame.setSize(400,400);

        JPanel panel= new JPanel();

        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);        
        panel.setSize(300,300);

        GridBagConstraints constraint = new GridBagConstraints();

        JLabel label = new JLabel("Hello");
        label.setBackground(Color.RED);
        label.setOpaque(true);
        JLabel label2 = new JLabel("Hey");
        label2.setBackground(Color.GREEN);
        label2.setOpaque(true);
        JButton button = new JButton("Say");

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        panel.add(label, constraint);

        constraint.fill = GridBagConstraints.VERTICAL;
        constraint.gridx = 2;
        constraint.gridy = 0;
        panel.add(label2, constraint);

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 1;
        toolbar.add(button);
        toolbar.addSeparator();

        panel.add(toolbar, constraint);
        panel.setBackground(Color.WHITE);

        Container pane = frame.getContentPane();
        pane.add(toolbar, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Grid g = new Grid();
    }
}