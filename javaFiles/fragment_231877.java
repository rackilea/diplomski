import java.awt.Component;
import java.awt.Container;
import java.util.stream.Stream;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class IterateOverJTextField {

    private static void iterateOverJTextFields(Container container) {
        // You have to call getComponents in order to access the
        // container's children.
        // Then you have to check the type of the component. 
        // In your case you're looking for JTextField. 
        // Then, you do what you want...
        // Old-style
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                System.out.println(((JTextField) component).getText());
            }
        }

        // New-style with Stream
        Stream.of(container.getComponents())
              .filter(c -> c instanceof JTextField)
              .map(c -> ((JTextField) c).getText())
              .forEach(System.out::println);
    }

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.add(new JTextField("text 1"));
        panel.add(new JTextField("text 2"));
        panel.add(new JTextField("text 3"));
        panel.add(new JTextField("text 4"));

        // You have to work with your container
        // the has the 74 fields. I created this 
        // panel just to test the code.
        iterateOverJTextFields(panel);
    }

}