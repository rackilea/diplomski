public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            VBox root = new VBox();

             MenuBar menuBar = new MenuBar();

            final Menu menu = new Menu( "Items");

            for( int i=0; i < 10; i++) {

                CheckBox cb = new CheckBox( "Item " + i);

                // workaround: the color of the labels is wrong (white text on white background), we have to set it explicitly
                cb.setStyle("-fx-text-fill: -fx-text-base-color");

                CustomMenuItem cmi = new CustomMenuItem( cb);
                cmi.setHideOnClick(false);

                menu.getItems().add( cmi);

            }

            menu.getItems().add( new MenuItem( "This one doesn't stay open"));

            menuBar.getMenus().add( menu);


            root.getChildren().add( menuBar);

            Scene scene = new Scene(root,400,400);

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