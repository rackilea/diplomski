public class HTMLEditorSample extends Application {

    @Override
    public void start(Stage stage) {

        final HTMLEditor htmlEditor = new HTMLEditor();

        Scene scene = new Scene(htmlEditor, 800, 600);
        stage.setScene(scene);
        stage.show();

        Button button = (Button) htmlEditor.lookup(".html-editor-paste");
        button.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            modifyClipboard();
        });

        htmlEditor.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if( e.isControlDown() && e.getCode() == KeyCode.V) {
                modifyClipboard();
            }
        });

    }

    private void modifyClipboard() {
        Clipboard clipboard = Clipboard.getSystemClipboard();

        String plainText = clipboard.getString();
        ClipboardContent content = new ClipboardContent();
        content.putString(plainText);

        clipboard.setContent(content);
    }

    public static void main(String[] args) {
        launch(args);
    }
}