private static void transferShape (XSSFSheet sheet, XSSFSheet newSheet) {
    XSSFDrawing drawing = sheet.createDrawingPatriarch();

    for(XSSFShape shape : drawing.getShapes()) {
        if(shape instanceof XSSFPicture) {
            transferPicture(shape, newSheet);
        }
    }
}

private static void transferPicture(XSSFShape shape, XSSFSheet newSheet) {
    XSSFPicture picture = (XSSFPicture) shape;

    XSSFPictureData xssfPictureData = picture.getPictureData();
    XSSFClientAnchor anchor = (XSSFClientAnchor) shape.getAnchor();

    int col1 = anchor.getCol1();
    int col2 = anchor.getCol2();
    int row1 = anchor.getRow1();
    int row2 = anchor.getRow2();

    int x1 = anchor.getDx1();
    int x2 = anchor.getDx2();
    int y1 = anchor.getDy1();
    int y2 = anchor.getDy2();

    XSSFWorkbook newWb = newSheet.getWorkbook();
    XSSFCreationHelper newHelper = newWb.getCreationHelper();
    XSSFDrawing newDrawing = newSheet.createDrawingPatriarch();
    XSSFClientAnchor newAnchor = newHelper.createClientAnchor();

    // Row / Column placement.
    newAnchor.setCol1(col1);
    newAnchor.setCol2(col2);
    newAnchor.setRow1(row1);
    newAnchor.setRow2(row2);

    // Fine touch adjustment along the XY coordinate.
    newAnchor.setDx1(x1);
    newAnchor.setDx2(x2);
    newAnchor.setDy1(y1);
    newAnchor.setDy2(y2);

    int newPictureIndex = newWb.addPicture(xssfPictureData.getData(), xssfPictureData.getPictureType());

    XSSFPicture newPicture = newDrawing.createPicture(newAnchor, newPictureIndex);
}