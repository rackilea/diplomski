public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(new Label("IMAGINE A BEAUTIFUL APPLICATION HERE"));
        vBox.setAlignment(Pos.CENTER);

        Button button = new Button("Im gonna steal your next click");
        button.setOnAction(event -> {
            System.out.println("Firing Button Action");
            openTransparentWindow();
            System.out.println("Button Action Finished Firing");
        });

        vBox.getChildren().add(button);

        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openTransparentWindow(){
        VBox vBox = new VBox();

        Stage stage = new Stage();
        stage.setScene(new Scene(vBox));
        //stage.setOpacity(0.5f); //Uncomment if you want to test and see the stage
        stage.setOpacity(0f);
        stage.setMaximized(true);

        vBox.setOnMouseClicked(event ->{
            System.out.println("event.getX() = " + event.getX());
            System.out.println("event.getY() = " + event.getY());
            System.out.println("event.getScreenX() = " + event.getScreenX());
            System.out.println("event.getScreenY() = " + event.getScreenY());
            stage.close();
        });

        stage.showAndWait();
    }
}