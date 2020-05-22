import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class Calculator1 {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Calculator1");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new MigLayout("fill, wrap 4", "[25%][25%][25%][25%]", "[shrink]"));

        frame.add(new JTextField("                                               "),"span 4, wrap");
        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("+"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("-"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));
        frame.add(new JButton("*"));
        frame.add(new JButton("0"));
        frame.add(new JButton("/"));
        frame.add(new JButton("="));

        frame.pack();
        frame.setVisible(true);
    }
}