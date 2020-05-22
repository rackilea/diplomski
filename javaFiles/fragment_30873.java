ColorAdjust hueShift = new ColorAdjust();
hueShift.setHue(-.3);

image.setOnMouseEntered(e-> {
    image.setEffect(hueShift);
});

image.setOnMouseExited(e-> {
    image.setEffect(null);
});