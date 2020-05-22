import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import components.DocumentSizeFilter;

public class Test {

    public static void main(String[] args) {
        new TestFrame().setVisible(true);
    }

    private static class TestFrame extends JFrame{
        private JTextField textField;
        private DefaultStyledDocument doc;
        private JLabel remaningLabel = new JLabel();

        public TestFrame() {
            setLayout(new BorderLayout());

            textField = new JTextField();
            doc = new DefaultStyledDocument();
            doc.setDocumentFilter(new DocumentSizeFilter(500));
            doc.addDocumentListener(new DocumentListener(){
                @Override
                public void changedUpdate(DocumentEvent e) { updateCount();}
                @Override
                public void insertUpdate(DocumentEvent e) { updateCount();}
                @Override
                public void removeUpdate(DocumentEvent e) { updateCount();}
            });
            textField.setDocument(doc);

            updateCount();

            add(textField, BorderLayout.CENTER);
            add(remaningLabel, BorderLayout.SOUTH);

            setLocationRelativeTo(null);
            pack();
        }

        private void updateCount()
        {
            remaningLabel.setText((500 -doc.getLength()) + " characters remaining");
        }
    }
}