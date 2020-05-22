import java.awt.*;
import javax.swing.*;

class ColoredButtons {

    ColoredButtons() {
        JPanel gui = new JPanel(new GridLayout(1,0,5,5));

        JButton one = new JButton("One");
        one.setBackground(Color.RED);
        JButton two = new JButton("Two");
        two.setBackground(Color.RED);

        gui.add(one);
        gui.add(two);

        JOptionPane.showMessageDialog(null, gui);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColoredButtons();
            }
        });
    }
}