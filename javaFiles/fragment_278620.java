import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @see https://stackoverflow.com/a/38282886/230513
 */
public class Test {

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Description"));
        JTextArea movieDescription = new JTextArea(10, 20);
        panel.add(new JScrollPane(movieDescription));
        movieDescription.setLineWrap(true);
        movieDescription.setWrapStyleWord(true);
        movieDescription.setText(movieDescription.toString());
        return panel;
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(createPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}