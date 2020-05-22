openButton.setStyle("-fx-padding: 0;");

SVGPath shape = new SVGPath();
shape.setContent("M 18 0 "
    + "H 251 C 265 0  277 7  277 25 "
    + "V 52  C 277 69 265 76 251 76 "
    + "H 18  C 12  76 0   69 0   52 "
    + "V 25  C 0   7  12  0  18  0  "
    + "z");
shape.setFill(Color.BLACK);

openButton.setShape(shape);
openButton.setClip(shape);