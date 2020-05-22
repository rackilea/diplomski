public class ranshap extends Application {
  double x1, y1, x2, y2;
  Rectangle rectangle;
  Circle circle;
  Color rectangleColor;
  Color circleColor;
  Button b;
  Pane pane;
  Scene scene;
  Stage stage;

  @Override
  public void start(Stage stage) {
    stage.setTitle("Drawing Rectangle and Circle");
    CreateRect c = new CreateRect();
    b = new Button("Click me");
    b.setOnAction(c);

    rectangle = new Rectangle();
    circle = new Circle();
    /*
     * rectangle.setX(50); rectangle.setY(50); rectangle.setWidth(200); rectangle.setHeight(50); rectangleColor= new
     * Color(0.0,0.8,0.2,0.6); rectangle.setFill(rectangleColor);
     */
    pane = new Pane();
    pane.getChildren().add(b);
    scene = new Scene(pane, 500, 300);
    stage.setScene(scene);
    stage.show();
  }

  private class CreateRect implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      double width, height, r, g, b, o, s, radius;
      Random generator = new Random();
      s = generator.nextDouble();
      pane.getChildren().remove(rectangle);
      pane.getChildren().remove(circle);
      if (s > 0.5) {
        pane.getChildren().add(rectangle);
        width = generator.nextDouble() * 100;
        height = generator.nextDouble() * 100;
        r = generator.nextDouble();
        g = generator.nextDouble();
        b = generator.nextDouble();
        o = generator.nextDouble();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangleColor = new Color(r, g, b, o);
        rectangle.setFill(rectangleColor);
      } else {
        pane.getChildren().add(circle);
        radius = generator.nextDouble() * 100;
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(radius);
        r = generator.nextDouble();
        g = generator.nextDouble();
        b = generator.nextDouble();
        o = generator.nextDouble();
        circleColor = new Color(r, g, b, o);
        circle.setFill(circleColor);
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}