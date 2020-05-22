@Override public void start(Stage stage) {
        // create web engine and view
        final WebEngine webEngine = new WebEngine(getClass().getResource("googlemap.html").toString());
        final WebView webView = new WebView(webEngine);
        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(webView,1000,700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.setVisible(true);
 }