public void texting(String inc) {    
    IntegerProperty textLength = new IntegerProperty();
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300 * inc.length())), 
        new KeyValue(textLength, inc.length()));
    labelHeader.textProperty().bind(Bindings.createStringBinding(() ->
        inc.substring(0, textLength.get()), textLength));
    timeline.play();

}