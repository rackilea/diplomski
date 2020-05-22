WebView wv = new WebView();
    wv.getEngine().setCreatePopupHandler(new Callback<PopupFeatures, WebEngine>() {

        @Override
        public WebEngine call(PopupFeatures p) {
            Stage stage = new Stage(StageStyle.UTILITY);
            WebView wv2 = new WebView();
            stage.setScene(new Scene(wv2));
            stage.show();
            return wv2.getEngine();
        }
    });


    StackPane root = new StackPane();
    root.getChildren().add(wv);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
    wv.getEngine().load("http://www.i-am-bored.com/pop_up_blocker_test.html");