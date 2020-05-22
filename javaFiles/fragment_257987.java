Pane pane=new Pane();
    Button bt=new Button("");
    bt.setPrefSize(40, 40);
    bt.setLayoutX(0);
    bt.setLayoutY(0);

    Line line1=new Line(20,20,20,100);
    PathTransition pt1=new PathTransition();
    pt1.setPath(line1);
    pt1.setDuration(Duration.seconds(2));

    Line line2=new Line(20,100,100,100);
    PathTransition pt2=new PathTransition();
    pt2.setPath(line2);
    pt2.setDuration(Duration.seconds(2));

    SequentialTransition st=new SequentialTransition(bt,pt1,pt2);
    st.play();
    st.setOnFinished(e->{
        System.out.println("X coordinate"+bt.getLayoutX());
        System.out.println("Y coordinate"+bt.getLayoutY());
        Line line3=new Line(100,100,100, 190);
        PathTransition pt3=new PathTransition();
        pt3.setPath(line3);
        pt3.setNode(bt);
        pt3.setDuration(Duration.seconds(2));
        pt3.play();
        primaryStage.show();

    });

    pane.getChildren().add(bt);
    Scene scene=new Scene(pane,250,250);
    primaryStage.setScene(scene);
    primaryStage.show();

    System.out.println("X coordinate"+bt.getLayoutX());
    System.out.println("Y coordinate"+bt.getLayoutY());