private ImageView myImageView ;

@Override
public void start(Stage primaryStage) {
    //Stage
    primaryStage.setTitle("title");
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane);


    Button load = new Button("Load");
    load.setOnAction(loadEventListener);

    myImageView = new ImageView();

    HBox rootBox = new HBox();
    rootBox.getChildren().addAll(load, myImageView);

    // presumably you intended this somewhere?
    pane.setCenter(rootBox);


    //Toolbar
    HBox toolbarArea = new HBox( 10 );
    toolbarArea.setPadding( new Insets( 10 ) );


    primaryStage.setScene(scene);
    primaryStage.show();

    //Puts buttons on bottom bar
    toolbarArea.getChildren().addAll( load );
    pane.setBottom( toolbarArea );
}