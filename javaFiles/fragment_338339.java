import javax.swing.JFrame;
import javax.swing.JTextPane;

public class MainTextPane {
    public static void main(final String[] args) {
        final JTextPane pane = new JTextPane();
        pane.setText("Hello, this is a\nnew lined string! Hope JTextPane is what we are looking for here.");

        final JFrame frame = new JFrame("TextPane with new lines.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}