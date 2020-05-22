import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;

public class MainTextPane {
    public static void main(final String[] args) {
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();

        final JTextPane pane = new JTextPane();
        pane.setText("Hello, this is a\ntwo lined string!");
        final JTextPane pane2 = new JTextPane();
        pane2.setText("Next!");
        pane.setBorder(loweredbevel);
        pane2.setBorder(loweredbevel);


        final JFrame frame = new JFrame("TextPane with new lines.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout()); //Added this line of code...
        frame.getContentPane().add(pane);
        frame.getContentPane().add(pane2);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}