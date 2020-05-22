Platform.runLater(new Runnable() {
    @Override public void run() {
        view = new WebView();
        engine = view.getEngine();
        jfxPanel.setScene(new Scene(view));
        Platform.setImplicitExit(false); // Otherwise cannot open report window a second time
    }
});