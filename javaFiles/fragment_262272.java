import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

public class TestInputVerifier {

    public static void main(String[] args) {
        new TestInputVerifier();
    }

    public TestInputVerifier() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JTextField field = new JTextField(20);
            field.setInputVerifier(new RegExpInputVerifier("^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$"));
            add(field, gbc);

            field = new JTextField(20);
            field.setInputVerifier(new RegExpInputVerifier("^[789]\\d{9}$"));
            add(field, gbc);
        }

    }

    public class RegExpInputVerifier extends InputVerifier {

        private String expression;

        public RegExpInputVerifier(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return expression;
        }

        @Override
        public boolean verify(JComponent input) {
            boolean verified = false;
            if (input instanceof JTextComponent) {
                JTextComponent field = (JTextComponent) input;
                String regNo1 = field.getText();
                Pattern pattern1 = Pattern.compile(expression);
                Matcher matcher1 = pattern1.matcher(regNo1);
            }
            return verified;
        }
    }
}