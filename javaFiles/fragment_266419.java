final TextField tf = new TextField();
tf.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {

    @Override
    public void handle(KeyEvent t) {
        if (KeyEvent.KEY_TYPED == t.getEventType()) {
            // put character to the first position
            tf.setText(t.getCharacter() + tf.getText());
        }
        t.consume(); // doesn't allow TextField to handle keyboard events by itself
    }
});