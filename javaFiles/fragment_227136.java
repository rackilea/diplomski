public class ButtonWithMultipleIcons extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            Group group = new Group();

            Button button = new Button();
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            HBox hBox = new HBox();

            ImageView icon1 = new ImageView( getClass().getResource( "icon1.png").toExternalForm());
            ImageView icon2 = new ImageView( getClass().getResource( "icon2.png").toExternalForm());

            Label label = new Label("Text");

            //make the button grow if you want the right icon to always be on the right of the button :
            label.setMaxWidth(Long.MAX_VALUE);

            HBox.setHgrow(label, Priority.ALWAYS);


            hBox.getChildren().addAll( icon1, label, icon2);

            button.setGraphic(hBox);

            group.getChildren().add( button);

            Scene scene = new Scene(group,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}