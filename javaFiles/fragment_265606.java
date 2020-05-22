import javax.swing.*;
import java.awt.*;

public class Windowing {
    public static void main( String [] args ) {
        Windowing windowing = new Windowing();
        windowing.showFrame();
    }
    void showFrame(){
        JFrame frame = new JFrame("Total recall");
        JButton push = new JButton("Push");
        JTextField wager = new JTextField(15);

        // Panels do have "FlowLayout"
        JPanel panel = new JPanel();
        panel.add(wager);
        panel.add(push);

        frame.add( panel );
        frame.pack();
        frame.setVisible(true);

    }
}