public class VBoxSample extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vBox1 = new VBox();
        for( int i=0; i < 10; i++) {
            vBox1.getChildren().add( new Text( "Item " + i));
        }

        VBox vBox2 = new VBox();
        for( int i=0; i < 10; i++) {
            vBox2.getChildren().add( 0, new Text( "Item " + i)); // add on top
        }

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.getChildren().addAll(vBox1, vBox2);

        stage.setScene(new Scene(new StackPane( hBox), 300, 250));
        stage.show();
    }

}