public class FXBounds extends Application {

    private Pane root;

    @Override
    public void start(Stage primaryStage) {

        root = new Pane();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        check(1,1,50,50, true);
        check(100,100,50,50, true);
        check(-5,-5,30,30, true);
        check(-50,0,30,30, false);
    }

    private void check(int x, int y, int width, int height, boolean in) {
        Rectangle rect = new Rectangle(x, y, width, height);
        root.getChildren().add(rect);
        System.out.println(in == inTheWindow(rect));
    }

    private boolean inTheWindow(Rectangle rect) {
        return rect.getBoundsInParent().intersects(root.getLayoutBounds()) || root.getLayoutBounds().contains(rect.getBoundsInParent());
    }
}