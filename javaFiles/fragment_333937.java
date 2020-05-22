private WebView InitWebview(){

    //Create browser
    WebView browser = new WebView();
    WebEngine render = browser.getEngine();

    //Load simple HTML
    String editor = WebviewInputValue.class.getResource("editor.html").toExternalForm();
    render.load(editor);

    //Listen for state change
    render.getLoadWorker().stateProperty().addListener((ov, o, n) -> {
        if (Worker.State.SUCCEEDED == n) {
            render.setOnStatusChanged(webEvent -> {

                //Call value change
                onValueChange(webEvent.getData());
            });
        }
    });

    return browser;
}