position.setLowerLeftX(418);
position.setLowerLeftY(110);
position.setUpperRightX(523);
position.setUpperRightY(133);
polygon.setRectangle(position);
float[] vertices = {418, 110, 523, 110, 522, 132, 419, 133};
COSArray verticesArray = new COSArray();
for (float v : vertices)
    verticesArray.add(new COSFloat(v));
polygon.getCOSObject().setItem(COSName.VERTICES, verticesArray);