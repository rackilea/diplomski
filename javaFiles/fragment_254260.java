import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
    JLabel label;
    JComboBox combo;
    JButton button;
    JPanel pane;
    JFrame frame;

    JPanel create1stRow() {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.setOpaque(false);
        String options[] = {"New Delhi", "Bangalore", "Chennai"};
        label = new JLabel("FROM");
        combo = new JComboBox(options);

        pane.add(label);
        pane.add(combo);
        return pane;
    }

    JPanel create2ndRow() {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.setOpaque(false);
        String options[] = {"Goa", "Kashmir", "Hyderabad"};
        label = new JLabel("TO");
        combo = new JComboBox(options);

        pane.add(label);
        pane.add(combo);
        return pane;
    }

    JPanel create3rdRow() {
        JPanel pane = new JPanel();
        JPanel dataPane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.setOpaque(false);
        dataPane.setOpaque(false); //forgot to add this line when I took the pic
        dataPane.setLayout(new GridLayout(2, 3)); //2 rows, 3 cols, so we can have the combos with their text aligned

        String days[] = {"1", "2", "3", "4", "5"}; //Too lazy to write 31 days
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May"}; //Too lazy to write 12 months
        String years[] = {"2016", "2017", "2018", "2019", "2020"};
        label = new JLabel("DATE");
        combo = new JComboBox(days);

        //We add the combos
        dataPane.add(combo);
        combo = new JComboBox(months); //We're reusing the object, but change the data
        dataPane.add(combo);
        combo = new JComboBox(years); //The same as above
        dataPane.add(combo);

        //Now we add the labels
        dataPane.add(new JLabel("DAYS"));
        dataPane.add(new JLabel("MONTHS"));
        dataPane.add(new JLabel("YEARS"));

        pane.add(label);
        pane.add(dataPane); //We add the whole pane to another one
        return pane;
    }

    JPanel create4thRow() {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.setOpaque(false);
        button = new JButton("Search");

        pane.add(button);
        return pane;
    }

    public Test() {
        frame = new JFrame("Test");
        frame.setContentPane(new JLabel(new ImageIcon("C:/Users/Frakcool/workspace/StackOverflowProjects/src/test/Air.jpg")));
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        pane = create1stRow();
        frame.add(pane);
        pane = create2ndRow();
        frame.add(pane);
        pane = create3rdRow();
        frame.add(pane);
        pane = create4thRow();
        frame.add(pane);

        frame.pack();
        //frame.setSize(500, 500); //If your image is too large use this
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String args[]) {
        new Test();
    }
}