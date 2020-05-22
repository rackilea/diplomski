public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane bord = new BorderPane();
        HBox hb = new HBox();
        GridPane griglia = new GridPane();
        Text server = new Text("SERVER");
        griglia.add(server, 1, 0);
        griglia.add(new Text("Numero Porta"), 0, 1);
        griglia.add(new TextField(), 1, 1);
        griglia.setVgap(5.0);
        griglia.setHgap(5.0);
        GridPane.setValignment(server, VPos.CENTER);
        GridPane.setHalignment(server, HPos.CENTER);
        hb.getChildren().add(griglia);
        hb.setStyle("-fx-border-color:red");
        hb.setAlignment(Pos.CENTER);
        bord.setTop(hb);
        primaryStage.setScene(new Scene(bord, 800, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}