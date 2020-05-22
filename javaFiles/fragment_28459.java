engine.documentProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue == null) {
        return;
    }
    JSObject window = (JSObject)engine.executeScript("window");
    window.setMember("controller", mainController);
});