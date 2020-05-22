public class CursorSimulator {

    private final FadeTransition fade;

    public CursorSimulator(Image image, Scene scene, ObservableList<Node> rootChildrenWriteable, double hotspotX, double hotspotY) {
        ImageView imageView = new ImageView(image);
        imageView.setManaged(false);
        imageView.setMouseTransparent(true);

        fade = new FadeTransition(Duration.seconds(2), imageView);
        fade.setFromValue(0);
        fade.setToValue(1);

        // keep image on top
        rootChildrenWriteable.addListener((Observable o) -> {
            if (imageView.getParent() != null
                    && rootChildrenWriteable.get(rootChildrenWriteable.size() - 1) != imageView) {
                // move image to top, after changes are done...
                Platform.runLater(() -> imageView.toFront());
            }
        });
        scene.addEventFilter(MouseEvent.MOUSE_ENTERED, evt -> {
            rootChildrenWriteable.add(imageView);
        });
        scene.addEventFilter(MouseEvent.MOUSE_EXITED, evt -> {
            rootChildrenWriteable.remove(imageView);
        });
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, evt -> {
            imageView.setLayoutX(evt.getX() - hotspotX);
            imageView.setLayoutY(evt.getY() - hotspotY);
        });
        scene.setCursor(Cursor.NONE);
    }

    public void fadeOut() {
        fade.setRate(-1);
        if (fade.getStatus() != Animation.Status.RUNNING) {
            fade.playFrom(fade.getTotalDuration());
        }
    }

    public void fadeIn() {
        fade.setRate(1);
        if (fade.getStatus() != Animation.Status.RUNNING) {
            fade.playFromStart();
        }
    }

}