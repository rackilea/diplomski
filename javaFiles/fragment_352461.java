import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().createAndShowUI();
            }
        });
    }

    private void createAndShowUI() {
        final JFrame frame = new JFrame("Test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(frame);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(JFrame frame) {
        final JTextField jtf = new JTextField(20);
        final JTextArea ta = new JTextArea(20,20);

        ta.setEditable(false);

        jtf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                ta.setText(jtf.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                ta.setText(jtf.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            //Plain text components don't fire these events.
            }
        });

        frame.getContentPane().add(jtf, BorderLayout.WEST);
        frame.getContentPane().add(ta, BorderLayout.EAST);
    }
}