public class Controller {

    @FXML
    private Group rootGroup;
    private Group zoomGroup;

    private double scale = 1;

    public void initialize() {
        zoomGroup = new Group();

        Image image = new Image(getClass().getResourceAsStream("image.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(50);

        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setCenterX(100);
        circle.setCenterY(200);
        circle.setFill(Paint.valueOf("RED"));

        zoomGroup.getChildren().add(imageView);
        zoomGroup.getChildren().add(circle);
        rootGroup.getChildren().add(zoomGroup);
    }

    public void scrolling(ScrollEvent scrollEvent) {
        if (scrollEvent.getDeltaY() > 0) {
            scale += 0.1;
        } else if (scrollEvent.getDeltaY() < 0) {
            scale -= 0.1;
        }
        zoomGroup.setScaleX(scale);
        zoomGroup.setScaleY(scale);
    }
}