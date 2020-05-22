public class HTMLEditorSample extends Application {

    @Override
    public void start(Stage stage) {

        final HTMLEditor htmlEditor = new HTMLEditor();

        Scene scene = new Scene(htmlEditor, 800, 600);
        stage.setScene(scene);
        stage.show();

        Button button = (Button) htmlEditor.lookup(".html-editor-paste");
        button.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            System.out.println("paste pressed");
            // e.consume();
        });

        htmlEditor.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if( e.isControlDown() && e.getCode() == KeyCode.V) {
                System.out.println( "CTRL+V pressed");
                // e.consume();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}