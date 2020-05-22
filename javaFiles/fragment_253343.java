public void texting(String inc) {    
    IntegerProperty textLength = new IntegerProperty();
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300)), e -> {
        textLength.set(textLength.get()+1);
        labelHeader.setText(inc.substring(0, textLength.get()));
    });
    timeline.setCycleCount(inc.length());
    timeline.play();

}