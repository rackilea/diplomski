import java.awt.*;
import javax.swing.*;
public class CheckBoxesInALoop {
    JFrame frame;
    JCheckBox box;
    JPanel boxPane, buttonPane;
    JButton button;
    public static void main (String args[]) {
        new CheckBoxesInALoop();
    }

    public CheckBoxesInALoop() {
        frame = new JFrame("Boxes added in a loop");
        boxPane = new JPanel();
        buttonPane = new JPanel();
        button = new JButton("I do nothing");

        boxPane.setLayout(new FlowLayout()); //Horizontal add
        //boxPane.setLayout(new BoxLayout(boxPane, BoxLayout.PAGE_AXIS)); //Vertical add

        for (int i = 0; i < 5; i++) { //Change for your array list boxes
            box = new JCheckBox("I am the " + (i + 1) + " checkbox"); //we re use the same "box" object (similar to your arraylist)
            boxPane.add(box);
        }
        buttonPane.add(button);

        frame.add(boxPane, BorderLayout.PAGE_START);
        frame.add(buttonPane, BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}