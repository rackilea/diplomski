public class Parser {  // does no longer extend Index
    String url;

    public Parser(String urlInput) {
        this.url = urlInput;
    }

    public void hello(JEditorPane editorPane) {  // has argument now
        editorPane.setText("Hello World");
    }
}