import javax.swing.*;
import java.awt.*;

public class GridBagSeparator1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Laying Out Components in a Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setBackground(Color.black);
        JSeparator sep1 = new JSeparator(SwingConstants.HORIZONTAL);
        sep1.setBackground(Color.blue);
        JSeparator sep2 = new JSeparator(SwingConstants.HORIZONTAL);
        sep2.setBackground(Color.green);
        JSeparator sep3 = new JSeparator(SwingConstants.HORIZONTAL);
        sep3.setBackground(Color.red);

        frame.setLayout(new GridLayout(4, 0));
        frame.add(sep);
        frame.add(sep1);
        frame.add(sep2);
        frame.add(sep3);
        frame.pack();
        frame.setVisible(true);
    }
}