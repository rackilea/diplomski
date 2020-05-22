@Override
public void start(Stage primaryStage) throws Exception
{
    TilePane panel = new TilePane();
    panel.setTileAlignment(Pos.CENTER_LEFT);

    for (int i = 0; i < 25; i++)
    {
        panel.getChildren().add(new Label(randomAlphabetic(10)));
    }

    Label title = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    title.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-wrap-text:true; -fx-border-color:black;"
            + "-fx-text-alignment: center; -fx-alignment: center; -fx-max-width:Infinity; -fx-padding: 5;");


    VBox box = new VBox(title, panel);
    box.setFillWidth(true); // or box.setStyle("-fx-fill-width: true ;")

    box.setPadding(new Insets(10));

    primaryStage.setScene(new Scene(box, 400, 400));
    primaryStage.show();

}