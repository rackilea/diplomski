private Button nextButton ;

@Override
public void start(Stage primaryStage) {

    VBox root = new VBox();

    Button b1 = new Button("Red");
    Button b2 = new Button("Yellow");
    Button b3 = new Button("Green");

    nextButton = b1 ;

    root.getChildren().add(b1);
    root.getChildren().add(b2);
    root.getChildren().add(b3);

    Scene scene = new Scene(root);

    primaryStage.setTitle("Traffic");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();

    b1.setOnAction((ActionEvent t) -> {
        if (nextButton==b1) {
            nextButton=b2 ;
        } else {
            System.out.println("Wrong");
        }
    });

    b2.setOnAction((ActionEvent t1) -> {
        // etc
    });

    b3.setOnAction((ActionEvent t2) -> {
        // etc
    });

}