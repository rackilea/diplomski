public class MyFrame exentds JFrame {
    public MyFrame() {
        initComponents();
        addDocumentListenerToField();
    }

    private void addDocumentListenerToField() {
        jTextField.getDocument().addDocumentListener(..);
    }
}