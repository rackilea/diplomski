import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.NumberFormatter;

public class Test {

    private JFormattedTextField input, input2;
    private NumberFormatter formatter;
//    private PropertyChangeListener listener;
    private DocumentListener listener;

    public Test() {
        formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        input = new JFormattedTextField(formatter);
        input2 = new JFormattedTextField(formatter);

        listener = new DocumentListener() {

            private Document source = null;

            protected void update(Document doc) {
                if (source == null) {
                    System.out.println("Update");
                    source = doc;
                    if (source.equals(input.getDocument())) {
                        input2.setText(input.getText());
                    } else if (source.equals(input2.getDocument())) {
                        input.setText(input2.getText());
                    }
                    source = null;
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update(e.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update(e.getDocument());
            }
        };
//        listener = new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                convert(evt);
//            }
//        };

        input.getDocument().addDocumentListener(listener);
        input2.getDocument().addDocumentListener(listener);

        input.setColumns(4);
        input2.setColumns(4);
//        input.addPropertyChangeListener("value", listener);
//        input2.addPropertyChangeListener("value", listener);
        input.setValue(0.0);
        JPanel panel = new JPanel();
        panel.add(input);
        panel.add(input2);

        JOptionPane.showMessageDialog(null, panel);
    }

    private void convert(PropertyChangeEvent evt) {
        if (evt.getSource() == input) {
            if (evt.getSource() != null) {
                double temp;
                temp = converter((Double) evt.getNewValue());
                input2.setValue(temp);
            }

        }

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });

    }

    private double converter(double value) {
        value = value * 2;

        return value;
    }

}