root.getChildren().addListener(new ListChangeListener<Node>() {
    @Override
    public void onChanged(ListChangeListener.Change<? extends Node> change) {
        Platform.runLater(new Runnable() {
            public void run() { r1.toFront(); }                 
        });
    }
});