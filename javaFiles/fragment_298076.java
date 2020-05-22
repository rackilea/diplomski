import java.awt.*;
import javax.swing.*;
public class LayoutManagersExample {
    public static void main(String args[]) {
        new LayoutManagersExample();
    }

    public LayoutManagersExample() {
        JFrame frame = new JFrame("Layout Managers Example");
        JPanel topPane = new JPanel();
        JPanel midPane = new JPanel();
        JPanel panesHolder = new JPanel();
        JLabel label = new JLabel("Top label");
        JTextField field = new JTextField();
        field.setColumns(5);

        topPane.setLayout(new FlowLayout());
        midPane.setLayout(new GridLayout(3, 2));

        topPane.add(label);
        topPane.add(field);

        midPane.add(new JButton("Button 1"));
        midPane.add(new JButton("Button 2"));
        midPane.add(new JButton("Hello I'm a button"));
        midPane.add(new JButton("HEY! Click me :)"));
        midPane.add(new JButton("I love you"));
        midPane.add(new JButton("This is another button"));

        panesHolder.setLayout(new BoxLayout(panesHolder, BoxLayout.Y_AXIS));
        panesHolder.add(topPane);
        panesHolder.add(midPane);

        frame.add(panesHolder);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}