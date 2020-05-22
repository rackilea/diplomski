import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/questions/9053824 */
public class JavaGUI extends JPanel {

    private Control control = new Control();
    private Keys keys = new Keys("Original starting value.");

    public JavaGUI() {
        this.setLayout(new GridLayout(0, 1));
        this.add(keys);
        this.add(control);
    }

    private class Control extends JPanel {

        public Control() {
            this.add(new JButton(new AbstractAction("Update") {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Command: " + e.getActionCommand());
                    keys.string = String.valueOf(System.nanoTime());
                    keys.label.setText(keys.string);
                }
            }));
        }
    }

    private class Keys extends JPanel {

        private String string;
        private JLabel label = new JLabel();

        public Keys(String s) {
            this.string = s;
            label.setText(s);
            this.add(label);
        }
    }

    private void display() {
        JFrame f = new JFrame("JavaGUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JavaGUI().display();
            }
        });
    }
}