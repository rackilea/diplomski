webView.sceneProperty().addListener(new ChangeListener<Scene>() {

        @Override
        public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene scene) {
            if (scene != null) {
                webView.setMaxSize(getScene().getWidth(), getScene().getHeight());
                webView.maxWidthProperty().bind(getScene().widthProperty());
                webView.maxHeightProperty().bind(getScene().heightProperty());
            } else {
                webView.maxWidthProperty().unbind();
                webView.maxHeightProperty().unbind();
            }
        }
    });