scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
@Override
public void handle(KeyEvent e) {
    if(e.getCode() == KeyCode.F11) {
        stage.setFullScreen(!stage.isFullScreen());
    }
}
});