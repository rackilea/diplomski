import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a button group containing blue and red, with blue selected
        final ButtonGroup color = new ButtonGroup();
        final JRadioButton blue = new JRadioButton("Blue");
        final JRadioButton red  = new JRadioButton("Red");
        color.add(blue);
        blue.setSelected(true);
        color.add(red);

        // Create a button group containing triangle and square, with triangle selected
        final ButtonGroup shape = new ButtonGroup();
        final JRadioButton triangle = new JRadioButton("Triangle");
        final JRadioButton square   = new JRadioButton("Square");
        shape.add(triangle);
        triangle.setSelected(true);
        shape.add(square);

        // Create a panel and add labels and the radio buttons
        final JPanel panel = new JPanel();
        panel.add(new JLabel("Choose a color:"));
        panel.add(blue);
        panel.add(red);
        panel.add(new JLabel("Choose a shape:"));
        panel.add(triangle);
        panel.add(square);

        // Show the dialog
        JOptionPane.showMessageDialog(
            null /*gameView*/, panel, "Message",
            JOptionPane.QUESTION_MESSAGE
        );

        // Print the selection
        if (blue.isSelected()) {
            System.out.println("Blue was selected");
        }
        else {
            System.out.println("Red was selected");
        }

        if (triangle.isSelected()) {
            System.out.println("Triangle was selected");
        }
        else {
            System.out.println("Square was selected");
        }
    }
}