import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DemoFrame extends JFrame {

    JTextField tf;
    JLabel lbl;

    public DemoFrame() {
        tf = new JTextField(10);
        lbl = new JLabel("Test");
        tf.getDocument().addDocumentListener(new DemoDocumentListener());
        lbl.setVisible(false);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(tf);
        this.add(lbl);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 100);
        this.setVisible(true);
    }

    public void checkForSpecialString() {
        if (tf.getText().contains("/")) {
            lbl.setVisible(true);
        } else {
            lbl.setVisible(false);
        }
    }

    class DemoDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkForSpecialString();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            checkForSpecialString();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            checkForSpecialString();
        }
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}