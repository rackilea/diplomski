public static boolean isChild(Parent parent, Node node) {
    while (node != null && node != parent) {
        node = node.getParent();
    }
    return parent == node;
}

@Override
public void start(Stage primaryStage) {
    VBox vb = new VBox();
    for (int i = 0; i < 360; i++) {
        TextField x = new TextField(String.valueOf(i));
        vb.getChildren().add(x);
    }
    ScrollPane sp = new ScrollPane(vb);
    sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    sp.setFitToWidth(true);

    TextField tf = new TextField();
    HBox root = new HBox();
    root.getChildren().addAll(sp, tf);

    Scene scene = new Scene(root, 300, 250);
    scene.focusOwnerProperty().addListener((o, oldVal, newVal) -> {
        if (isChild(vb, newVal)) {
            // get bounds of focused node in ScrollPane content
            Bounds bounds = newVal.getLayoutBounds();
            while (newVal != vb) {
                bounds = newVal.localToParent(bounds);
                newVal = newVal.getParent();
            }
            double h = vb.getHeight();
            double vH = sp.getViewportBounds().getHeight();

            // scroll node to bottom of the viewport if bottom is not in view
            if (bounds.getMaxY() > sp.getVvalue() * (h - vH) + vH) {
                sp.setVvalue((bounds.getMaxY() - vH) / (h - vH));
            }
        }
    });

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}