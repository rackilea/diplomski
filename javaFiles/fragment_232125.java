import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListenerDemo {

    public static JTextField getTextField() {
        final JTextField field = new JTextField(10);
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println(field.getText());    
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(field.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JOptionPane.showMessageDialog(null, getTextField());
            }
        });
    }
}