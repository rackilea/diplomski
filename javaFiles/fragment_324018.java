public void start(Stage primaryStage) throws Exception {

    Pane pane = new Pane();
    final Scene scene = new Scene(pane, 500, 500);
    final Circle circle = new Circle(250, 250, 20);
    circle.setFill(Color.WHITE);
   circle.setStroke(Color.BLACK);
    pane.getChildren().add(circle);
     circle.setFocusTraversable(true);
    circle.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            if ((e.getCode() == KeyCode.UP) && (circle.getCenterY() >= 5)) {
                circle.setCenterY(circle.getCenterY() - 5);
            }

            else if ((e.getCode() == KeyCode.DOWN && (circle.getCenterY() <= scene.getHeight() - 5))) {
                circle.setCenterY(circle.getCenterY() + 5);
            }
            else if ((e.getCode() == KeyCode.RIGHT) && (circle.getCenterX() <= scene.getWidth() - 5)) {
                circle.setCenterX(circle.getCenterX() + 5);
            }
            else if ((e.getCode() == KeyCode.LEFT && (circle.getCenterX() >= 5))) {

                circle.setCenterX(circle.getCenterX()-5);
            }
        }
    });

  //creates new spots by clicking anywhere on the pane
    pane.setOnMouseClicked(new EventHandler<MouseEvent>() {  
      public void handle(MouseEvent event) {
            double newX = event.getX(); //getting the x-coordinate of the clicked area
            double newY = event.getY(); //getting the y-coordinate of the clicked area

            Circle newSpot = new Circle(newX, newY,20);
            newSpot.setFill(Color.WHITE);
            newSpot.setStroke(Color.BLACK);
            pane.getChildren().add(newSpot);

        }
    });

    primaryStage.setTitle("Move the circle");
    primaryStage.setScene(scene);
    primaryStage.show();
}