progressIndicator.progressProperty().addListener((ov, oldValue, newValue) -> {
     Text text = (Text) progressIndicator.lookup(".percentage");
     if(text!=null && text.getText().equals("Done")){
        text.setText("New Text");
        progressIndicator.setPrefWidth(text.getLayoutBounds().getWidth());
     }
});