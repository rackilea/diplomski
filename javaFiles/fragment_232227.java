public class EditorPanel extends JPanel {

    private JEditorPane editorPane;

    // ...

    public EditorPanel() {
        // ...
        editorPane = new JEditorPane( ... );
        super.add(editorPane);
        // ...
    }

    // ...

    public JEditorPane getEditorPane() {
        return editorPane;
    }
}