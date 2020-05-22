Popup popup = new Popup();
popup.getContent().add(new Label("A tooltip"));

PauseTransition hideTimer = new PauseTransition(Duration.seconds(1));
hideTimer.setOnFinished(e -> popup.hide());


Scene scene = ... ;

scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
    popup.show(scene.getRoot(), e.getScreenX(), e.getScreenY());
    hideTimer.playFromStart();

});