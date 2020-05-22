public class MyApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 430, 230, Color.WHITE);

        List<Rectangle> rectangles = new ArrayList<>();

        int width = 100;
        int height = 50;
        int pad = 6;

        // first row
        rectangles.add(createRect(pad, pad, width, height, Color.GREEN));
        rectangles.add(createRect(pad + (width + pad), pad, width, height, Color.GREEN.brighter()));
        rectangles.add(createRect(pad + (width + pad) * 2, pad, width, height, Color.GREEN.darker()));
        rectangles.add(createRect(pad + (width + pad) * 3, pad, width, height, Color.GREEN));

        // second row
        rectangles.add(createRect(pad + (width + pad) * 0.5, pad + (height + pad), width, height, Color.GREEN.brighter()));
        rectangles.add(createRect(pad + (width + pad) * 1.5, pad + (height + pad), width, height, Color.GREEN));
        rectangles.add(createRect(pad + (width + pad) * 2.5, pad + (height + pad), width, height, Color.GREEN.darker()));

        // third row
        rectangles.add(createRect(pad + (width + pad), pad + (height + pad) * 2, width, height, Color.GREEN.darker()));
        rectangles.add(createRect(pad + (width + pad) * 2, pad + (height + pad) * 2, width, height, Color.GREEN));

        // last row
        rectangles.add(createRect(pad + (width + pad) * 1.5, pad + (height + pad) * 3, width, height, Color.GREEN.brighter()));

        root.getChildren().addAll(rectangles);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Rectangle createRect(double x, double y, double width, double height, Color color) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(color);
        return rectangle;
    }
}