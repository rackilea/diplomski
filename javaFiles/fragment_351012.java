import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocListeenerDemo extends JFrame {
    private JTextField field;   
    private JLabel label;

    public DocListeenerDemo() {
        initComponents();
        addDocumentListenerToField();
    }

    private void initComponents() {
        setLayout(new GridLayout(0, 1));
        field = new JTextField(20);
        label = new JLabel("", SwingConstants.CENTER);
        add(field);
        add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
    }

    private void addDocumentListenerToField() {
        field.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent arg0) {doYourStuff();}
            public void insertUpdate(DocumentEvent arg0) {doYourStuff();}
            public void removeUpdate(DocumentEvent arg0) {doYourStuff();}
            public void doYourStuff() {
                label.setText(field.getText());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                DocListeenerDemo demo = new DocListeenerDemo();
                demo.setVisible(true);
            }
        });
    }
}