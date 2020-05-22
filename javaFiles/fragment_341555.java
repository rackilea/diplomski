import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.*;

/** @see https://stackoverflow.com/q/9610386/230513 */
public class Login {

    private static final String PWD = "pass";
    private static final String RESET = "Reset";
    private PlainDocument doc = new PlainDocument();
    private JTextField text = new JTextField(doc, "", 10);

    public Login() {
        doc.setDocumentFilter(new FieldFilter(PWD));
        JLabel label = new JLabel("Password is '" + PWD + "'", JLabel.RIGHT);
        label.setLabelFor(text);
        text.setToolTipText("Press ESC to reset.");
        text.getInputMap().put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), RESET);
        text.getActionMap().put(RESET, new Reset());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 2, 5, 5));
        p.add(label);
        p.add(text);
        JFrame f = new JFrame("Login");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setContentPane(p);
        f.setLocationByPlatform(true);
        f.pack();
        f.setVisible(true);
    }

    private static class FieldFilter extends DocumentFilter {

        private String password;
        private boolean unlocked;
        private StringBuilder sb = new StringBuilder();

        public FieldFilter(String password) {
            this.password = password;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
            if (unlocked) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                sb.append(text);
                unlocked = password.equals(sb.toString());
            }
        }

        public void reset() {
            sb.delete(0, sb.length());
            unlocked = false;
        }
    }

    private static class Reset extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField jtf = (JTextField) e.getSource();
            PlainDocument doc = (PlainDocument) jtf.getDocument();
            try {
                doc.remove(0, doc.getLength());
            } catch (BadLocationException ex) {
                ex.printStackTrace(System.err);
            }
            FieldFilter filter = (FieldFilter) doc.getDocumentFilter();
            filter.reset();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Login log = new Login();
            }
        });
    }
}