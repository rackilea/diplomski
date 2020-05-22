EventHandler<MouseEvent> lineOnMouseClicked = new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        System.out.println("Line has been clicked");
        t.consume(); // consume event -> no further propagation
    }
};


line.addEventHandler(MouseEvent.MOUSE_CLICKED, lineOnMouseClicked);
pane.addEventHandler(MouseEvent.MOUSE_CLICKED, paneOnMouseClicked);