WebEngine webEngine = webView.getEngine();
webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
  public void changed(ObservableValue ov, State oldState, State newState) {
    if (newState == Worker.State.SUCCEEDED) {

        // note next classes are from org.w3c.dom domain
        EventListener listener = new EventListener() {
            public void handleEvent(Event ev) {
                System.out.println(ev.getType());
            }
        };

        Document doc = webEngine.getDocument();
        Element el = doc.getElementById("textarea");
        ((EventTarget) el).addEventListener("keypress", listener, false);
    }
  }
});
webEngine.loadContent("<textarea id='textarea'></textarea>");