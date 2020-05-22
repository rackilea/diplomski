GaussianBlur blur = new GaussianBlur();
blur.setRadius(10);

ColorAdjust darker = new ColorAdjust();
darker.setBrightness(-.3);

darker.setInput(blur);

image.setOnMouseEntered(e-> {
    image.setEffect(darker);
});

image.setOnMouseExited(e-> {
    image.setEffect(null);
});