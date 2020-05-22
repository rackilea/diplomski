Rectangle boundingBox = new Rectangle(20,470,50,50);
    PdfFormXObject xObject = new PdfFormXObject(boundingBox);
    xObject.makeIndirect(pdfDoc);//Make sure the XObject gets added to the document
    PdfCanvas canvas = new PdfCanvas(xObject, pdfDoc);//Create a canvas from the XObject
    canvas.setStrokeColor(Color.BLUE).setLineWidth(3f).rectangle(35, 480, 30, 30).stroke();
    Image rect = new Image(xObject);
    table.addCell(rect);