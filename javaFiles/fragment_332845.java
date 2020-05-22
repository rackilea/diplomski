private class MyView extends Pane {

    MyView() {
        ...
        setPrefSize(300, 300);
        scene.widthProperty().bind(widthProperty());
        scene.heightProperty().bind(heightProperty());
    }