static final float INCH = 72;
float pw = page1.getMediaBox().getUpperRightX();
float ph = page1.getMediaBox().getUpperRightY();

PDAnnotationMarkup polygon = new PDAnnotationMarkup();
polygon.getCOSObject().setName(COSName.SUBTYPE, PDAnnotationMarkup.SUB_TYPE_POLYGON);
position = new PDRectangle();
position.setLowerLeftX(pw - INCH);
position.setLowerLeftY(ph - INCH);
position.setUpperRightX(pw - 2 * INCH);
position.setUpperRightY(ph - 2 * INCH);
polygon.setRectangle(position);
polygon.setColor(blue); // border color
polygon.getCOSObject().setItem(COSName.IC, red.toCOSArray()); // interior color
COSArray triangleVertices = new COSArray();
triangleVertices.add(new COSFloat(pw - INCH));
triangleVertices.add(new COSFloat(ph - 2 * INCH));
triangleVertices.add(new COSFloat(pw - INCH * 1.5f));
triangleVertices.add(new COSFloat(ph - INCH));
triangleVertices.add(new COSFloat(pw - 2 * INCH));
triangleVertices.add(new COSFloat(ph - 2 * INCH));
polygon.getCOSObject().setItem(COSName.VERTICES, triangleVertices);
polygon.setBorderStyle(borderThick);

annotations.add(polygon);