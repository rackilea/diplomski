import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class FileContentSubject implements Subject, DocumentListener {

    // private JTextArea textArea; // removed as a String field will suffice
    // private Document doc; // should not be a field!

    private String state;

    public String getState() {
        return this.state;
    }

    private SubjectImpl reference;

    @Override
    public void attach(Observer o) {
        reference.attach(o);
    }

    @Override
    public void detach(Observer o) {
        reference.detach(o);
    }

    @Override
    public void notifyAllObservers() {
        reference.notifyAllObservers();
    }

    public FileContentSubject() {
        reference = new SubjectImpl();

//      textArea = new JTextArea();
//      textArea.setTabSize(5);
//      textArea.setLineWrap(true);
//      textArea.setWrapStyleWord(true);
//      textArea.getDocument().addDocumentListener(this);
    }

    @Override
    public void changedUpdate(DocumentEvent arg0) {
    }

    @Override
    public void insertUpdate(DocumentEvent arg0) {
        Document doc = (Document) arg0.getDocument();
        try {
            // this.textArea.setText(doc.getText(0, doc.getLength()-1));
            this.state = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Editor e = (Editor) doc.getProperty("ownerEditor");
        reference.detach(e); // so it will not be notified of its own change
        notifyAllObservers(); // tell everybody else to catch up with the changes
        reference.attach(e); // reattaches the editor
    }

    @Override
    public void removeUpdate(DocumentEvent arg0) {
        Document doc = (Document) arg0.getDocument();
        try {
            // this.textArea.setText(doc.getText(0, doc.getLength()-1));
            this.state = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Editor e = (Editor) doc.getProperty("ownerEditor");
        reference.detach(e); // so it will not be notified of its own change
        notifyAllObservers(); // tell everybody else to catch up with the changes
        reference.attach(e); // reattaches the editor
    }

    // public String getJTextArea() {
    //     return textArea.getText();
    // }
}