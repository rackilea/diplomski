private void previewHtml(String url) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            JFrame fr = new JFrame();
            final JFXPanel fxPanel = new JFXPanel();
            fr.add(fxPanel);
            fr.setSize(1000, 600);
            fr.setVisible(true);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    final Group  rootGroup  =  new  Group();
                    final Scene scene = new Scene(rootGroup, 1000, 600, Color.WHITE);        
                    final WebView webView = WebViewBuilder.create().prefHeight(600).prefWidth(1000).build();
                    webView.getEngine().load(url);
                    rootGroup.getChildren().add(webView);
                    fxPanel.setScene(scene);
                    fxPanel.show();
                }
            });                
        }
    });

}


//You can add the following code to a button actionListener:

//prevew html from classpath:
previewHtml(getClass().getResource("/classpath-file.html").toExternalForm());

//prevew html from url:
previewHtml("https://stackoverflow.com/");