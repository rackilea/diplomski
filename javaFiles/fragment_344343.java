public void initBubbles(){
    final Image image = new Image("file:src/bubbles/images/bubble.png");
    // Create an event handler to be re-used for all the ImageView's
    final EventHandler eventHandler = new EventHandler<MouseEvent> () {
        @Override
        public void handle(MouseEvent event) {
            final ImageView iv = (ImageView) (event.getTarget());
            iv.setImage(new Image("popped.png"));
        }
    }
    for (int i = 0; i < bubbles.length; i++) {
        //Creates a new bubble
        bubbles[i] = new Bubble(image, 'A', 1);
        //Creates a new image view
        ivs[i] = new ImageView(image);
        // Register the event handler
        ivs[i].addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}