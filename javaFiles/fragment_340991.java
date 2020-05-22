final PauseTransition delay = new PauseTransition(Duration.seconds(3));

class FinishedHandler implements EventHandler<ActionEvent> {

    ListCell<String> source;

    @Override
    public void handle(ActionEvent event) {
        // do something, if the mouse is pressed for a certain time before releasing it
        System.out.println("long press on " + source.getItem());
    }

}

final FinishedHandler handler = new FinishedHandler();
delay.setOnFinished(handler);

listView.setCellFactory(lv -> new ListCell<String>() {

    {
        setOnMousePressed(evt -> {
            if (!isEmpty()) {
                handler.source = this;
                delay.play();
            }
        });
        setOnMouseReleased(evt -> {
            delay.stop();
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(item);
    }

});