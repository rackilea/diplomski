//When the "new menuitem" is clicked, then it must create
MenuItem newMenuItem = (MenuItem) fxmlLoader.getNamespace().get("new");
newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        final WebEngine webEngine = wv.getEngine();
        webEngine .reload();
        webEngine.getLoadWorker().stateProperty().addListener(
        new ChangeListener<State>() {
            public void changed(ObservableValue ov, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
                    JSObject jsobj = (JSObject) we.executeScript("window");
                    jsobj.setMember("liss", lissProg);
                }
            }
        });

    }
});