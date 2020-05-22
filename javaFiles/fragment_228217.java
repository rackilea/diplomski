import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Text {

    public static void main(String[] args) {
        new Text();
    }

    public Text() {
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
            setLayout(new GridBagLayout());

            JTextField field1 = new JTextField(10);
            JTextField field2 = new JTextField(10);
            JTextField field3 = new JTextField(10);

            DocumentListener dl = new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateFieldState();
                }

                protected void updateFieldState() {
                    String text = field1.getText() + " " + field2.getText();
                    field3.setText(text);
                }
            };

            field1.getDocument().addDocumentListener(dl);
            field2.getDocument().addDocumentListener(dl);
            field3.setEditable(false);

            add(field1);
            add(field2);
            add(field3);
        }

    }

}