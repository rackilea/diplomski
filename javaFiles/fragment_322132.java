clbtn.setOnAction(event -> {
    Color color = Color.web(colour.getText());
    R.setValue(color.getRed() * 255);
    G.setValue(color.getGreen() * 255);
    B.setValue(color.getBlue() * 255);
    circle.setFill(color);
});